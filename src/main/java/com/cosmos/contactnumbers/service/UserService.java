package com.cosmos.contactnumbers.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cosmos.contactnumbers.model.Users;
import com.cosmos.contactnumbers.model.backup.UserBackup;
import com.cosmos.contactnumbers.repository.UserBackupRepository;
import com.cosmos.contactnumbers.repository.UserRepository;
import com.cosmos.contactnumbers.util.UserUtil;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserUtil userUtil;
	
	@Autowired
	private UserBackupRepository userBackupRepository;

	public void addUsersToExcelorCSV() {
		
		
	}
	public String addUsersFromExcel() {
		// String str = "C://Users/91900/Desktop/GroceryDb/Expected.xlsx";
		String str = "C://Users/abhijimi/Desktop/Personal/WorkingCopies/hibernatedb/Expected.xlsx";

		try {
			File file = new File(str); // creating a new file instance
			FileInputStream fis = new FileInputStream(file); // obtaining bytes from the file
			// creating Workbook instance that refers to .xlsx file
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheetAt(0); // creating a Sheet object to retrieve object
			Iterator<Row> itr = sheet.iterator(); // iterating over excel file
			Long l = 0L;
			int i = 0;
			Users user = new Users();
			user.setAddedDate();
			while (itr.hasNext()) {
				Row row = itr.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					switch (cell.getCellType()) {
					case STRING:
						i++;
						switch (i) {
						case 1:
							user.setUserName(cell.getStringCellValue());
							break;
						case 2:
							user.setLocation(cell.getStringCellValue());
							break;
						case 3:
							user.setUserSource(cell.getStringCellValue());
							break;
						}
						break;
					case NUMERIC:
						l = (long) cell.getNumericCellValue();
						user.setMobileNumber(l);
						break;

					}
				}
				user.setGotWhatsapp(true);
				user.setUsefull(true);
				userRepository.save(user);
				i = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Success";
	}

	public Optional<Users> getUserByMobileNumber(Long mobileNumber) {
		// TODO Auto-generated method stub
		return userRepository.findById(mobileNumber);
	}

	public String updateUsers() {
		// TODO Auto-generated method stub
		List<Users> newusers = new LinkedList<Users>();
		List<Users> users = userRepository.findAll();
		for (Users user : users) {
			user.setGotWhatsapp(true);
			user.setUsefull(true);
			newusers.add(user);
		}
		userRepository.saveAll(newusers);
		return "Success";
	}

	public String backupUsers() {
		// TODO Auto-generated method stub
		List<Users> users = userRepository.findAll();
		List<UserBackup> backupUsers = new LinkedList<UserBackup>();
		UserBackup userBackup = null;
		for (Users user : users) {
			userBackup = new UserBackup(user.getMobileNumber(), user.getUserName(), user.getLocation(),
					user.getUserSource(), user.isGotWhatsapp(), user.isUsefull(), user.getAddedDate());
			backupUsers.add(userBackup);
		}
		userBackupRepository.saveAll(backupUsers);
		return "Success";
	}

	public Optional<Users> updateByMobileNumber(Long mobileNumber, Users user) {
		// TODO Auto-generated method stub
		userRepository.save(user);
		return null;
	}

	public Users saveUser(Users user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	public List<Users> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	public Optional<List<Users>> getAllUsersAddedYesterday() {
		// TODO Auto-generated method stub
		LocalDate yesterday = LocalDate.now().minusDays(1);
		System.out.println(yesterday);
		List<Users> users = userRepository.findByDate(yesterday);
		Optional<List<Users>> u = Optional.ofNullable(users);
		return u;
	}

	public void getAllUsersToFile() throws IOException {
		// TODO Auto-generated method stub
		List<Users> users = userRepository.findAll();
		userUtil.toFile(users);	
	}

	public List<Users> getAllUsersFromFile() throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return userUtil.fromFile();
	}


}

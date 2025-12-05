package genericutility;


import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class JavaUtility {
	public String getSystemDataYYYYMMDD() {
		Date DATE=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(DATE);
		return date;
	}
	
	public String getRequiredDate() {
		Date DATE=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		sdf.format(DATE);
		Calendar cal = sdf.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, 30);
		String Reqdate = sdf.format(cal.getTime());
		return Reqdate;
	}
	
	public int getRandomNumber() {
		Random Rnum=new Random();
		int randomNUM = Rnum.nextInt(999);
		return randomNUM;
	}
	
	public String getSystemTime() {
		return LocalDateTime.now().toString().replace(":", "-");
	}
	
	public String getUniqueFutureDate(int minDays, int maxDays) {

	    try {
	        // You may modify ONLY this file path if your project structure is different
	        String filePath = "./src/test/resources/usedLeaveDates.txt";
	        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");

	        File file = new File(filePath);

	        // Create file if not exists
	        if (!file.exists()) {
	            file.getParentFile().mkdirs();
	            file.createNewFile();
	        }

	        // Read already used dates
	        List<String> usedDates = Files.readAllLines(file.toPath());

	        Random random = new Random();

	        // Try up to 20 random attempts to find a unique date
	        for (int i = 0; i < 20; i++) {

	            int randomDays = random.nextInt((maxDays - minDays) + 1) + minDays;

	            LocalDate date = LocalDate.now().plusDays(randomDays);
	            String formattedDate = date.format(dateFormat);

	            // If date is not used yet, store it and return
	            if (!usedDates.contains(formattedDate)) {
	                Files.write(
	                        file.toPath(),
	                        (formattedDate + System.lineSeparator()).getBytes(),
	                        StandardOpenOption.APPEND
	                );
	                return formattedDate;
	            }
	        }

	        // If method fails to find unique date
	        throw new RuntimeException(
	                "No unique date found in the provided range. Increase maxDays or delete usedLeaveDates.txt");

	    } catch (Exception e) {
	        throw new RuntimeException("Error generating unique future date", e);
	    }
	}
	
	
	public String convertDateForHR(String date) {
	    DateTimeFormatter employeeFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	    DateTimeFormatter hrFormat = DateTimeFormatter.ofPattern("MMM. d, yyyy", Locale.ENGLISH);

	    LocalDate parsedDate = LocalDate.parse(date, employeeFormat);
	    return parsedDate.format(hrFormat);
	}
	
	
	public String getUniquePastDate(int minDays, int maxDays) {

	    try {
	        // FILE PATH (Modify only if needed)
	        String filePath = "./src/test/resources/usedPastDates.txt";
	        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");

	        File file = new File(filePath);

	        // Create file if not exists
	        if (!file.exists()) {
	            file.getParentFile().mkdirs();
	            file.createNewFile();
	        }

	        // Read already used dates
	        List<String> usedDates = Files.readAllLines(file.toPath());

	        Random random = new Random();

	        // Try generating a unique past date
	        for (int i = 0; i < 20; i++) {

	            // random number between minDays and maxDays
	            int randomDays = random.nextInt((maxDays - minDays) + 1) + minDays;

	            // Past date = Today - N days
	            LocalDate pastDate = LocalDate.now().minusDays(randomDays);
	            String formattedDate = pastDate.format(dateFormat);

	            // If date is not used yet → return it
	            if (!usedDates.contains(formattedDate)) {

	                // Save to file
	                Files.write(
	                        file.toPath(),
	                        (formattedDate + System.lineSeparator()).getBytes(),
	                        StandardOpenOption.APPEND
	                );

	                return formattedDate;
	            }
	        }

	        // If all tries exhausted
	        throw new RuntimeException("No unique past date found. Increase range or delete usedPastDates.txt");

	    } catch (Exception e) {
	        throw new RuntimeException("Error generating unique past date", e);
	    }
	}




}

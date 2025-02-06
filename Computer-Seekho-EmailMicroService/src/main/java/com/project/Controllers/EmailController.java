package main.java.com.project.Controllers;

import java.util.Map;

import main.java.com.Services.EmailSenderService;
@RestController
public class EmailController {
    @Autowired
	private EmailSenderService service;
	
	@PostMapping("/email")
	 public ResponseEntity<String> sendEmail(@RequestBody Map<String, Object> emailRequest) {
	        try {
	            String to = (String) emailRequest.get("to");
	            String studentName = (String) emailRequest.get("studentName");
	            service.sendAdmissionEmail(to,studentName);
	            return ResponseEntity.status(HttpStatus.OK).body("Email sent successfully");
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to send email: " + e.getMessage());
	        }
	    }
}

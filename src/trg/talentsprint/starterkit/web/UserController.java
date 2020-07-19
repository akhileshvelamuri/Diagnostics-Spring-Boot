package trg.talentsprint.starterkit.web;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import trg.talentsprint.starterkit.model.Booking;
import trg.talentsprint.starterkit.model.Lab;
import trg.talentsprint.starterkit.model.Test;
import trg.talentsprint.starterkit.model.User;
import trg.talentsprint.starterkit.service.BookingService;
import trg.talentsprint.starterkit.service.LabService;
import trg.talentsprint.starterkit.service.SecurityService;
import trg.talentsprint.starterkit.service.TestService;
import trg.talentsprint.starterkit.service.UserService;
import trg.talentsprint.starterkit.validator.UserValidator;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@Autowired
	private SecurityService securityService;

	@Autowired
	private UserValidator userValidator;

	@Autowired
	private LabService labService;

	@Autowired
	private TestService testService;

	@Autowired
	private BookingService bookService;

	@Value("${upload.location}")
	private String uploadDirectory;

	@GetMapping("/registration")
	public String registration(Model model) {
		model.addAttribute("userForm", new User());

		return "registration";
	}

	@PostMapping("/registration")
	public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
		userValidator.validate(userForm, bindingResult);

		if (bindingResult.hasErrors()) {
			return "registration";
		}

		userService.save(userForm);

		securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

		return "redirect:/welcome";
	}

	@GetMapping("/login")
	public String login(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("error", "Your username and password is invalid.");

		if (logout != null)
			model.addAttribute("message", "You have been logged out successfully.");

		return "login";
	}

	@GetMapping({ "/", "/welcome" })
	public String welcome(Model model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getName();
		String username = principal.toString();
		//model.addAttribute("username", username);
		model.addAttribute("username", username);
		if (username.equals("administrator")) {
			return "welcome";
		}
		return "customer";
			}

	///////////////////////////// DiagnosticsApplication//////////////////////////////////////////////////////////

	@GetMapping("/{username}/admin")
	public String admin(Model model, @PathVariable String username) {
		System.out.println(username);
		model.addAttribute("username", username);
		if (username.equals("administrator")) {
			return "welcome";
		}
		return "customer";
	}

	@GetMapping("/Addlabs")
	public String labCreationForm(Model model) {
		model.addAttribute("lab", new Lab());
		model.addAttribute("test", testService.findAll());
		return "AddLab";
	}

	@PostMapping("/addLab")
	public String addNewLab(@Valid @ModelAttribute Lab lab, @RequestParam(name = "testname") String testname,
			BindingResult result, Model model) {
		Test test = testService.searchIdByName(testname);
		long testid = test.getTid();
		lab.setTid(testid);
		labService.save(lab);
		model.addAttribute("lab", labService.findAll());
		return "welcome";
	}

	@GetMapping("/AddTest")
	public String testCreationForm(Model model) {
		model.addAttribute("test", new Test());
		return "AddTest";
	}

	@PostMapping("/addTest")
	public String addNewTest(@Valid @ModelAttribute Test test, BindingResult result, Model model) {
		testService.save(test);
		model.addAttribute("test", testService.findAll());
		return "welcome";
	}

	@GetMapping("/NewBooking")
	public String addNewBooking(Model model, @RequestParam(name = "username") String username) {
		// model.addAttribute("booking", new Booking());
		model.addAttribute("username", username);
		model.addAttribute("test", testService.findAll());
		// model.addAttribute("lab", labService.findAll());
		System.out.println(labService.findAll());
		return "NewBooking";
	}

	@GetMapping("/searchLab")
	public String seachLab(Model model, @RequestParam(name = "testname") String testname,
			@RequestParam(name = "username") String username) {
		Test t1 = testService.searchIdByName(testname);
		Long tid = t1.getTid();
		List<String> l = labService.searchLabsByTid(tid);
		model.addAttribute("username", username);
		model.addAttribute("testname", testname);
		model.addAttribute("lab", l);
		return "SearchLab";
	}

	@GetMapping("/booking")
	public String showSearchLab(Model model, @RequestParam(name = "testname") String testname,
			@RequestParam(name = "labname") String labname, @RequestParam(name = "username") String username) {
		model.addAttribute("username", username);
		model.addAttribute("testname", testname);
		model.addAttribute("labname", labname);
		// model.addAttribute("booking", new Booking());
		return "bookingDetails";
	}

	@PostMapping("/conform")
	public String conformData(Booking book, BindingResult result, Model model,
			@RequestParam(value = "testname", required = false, defaultValue = "") String testname,
			@RequestParam(value = "labname", required = false, defaultValue = "") String labname,
			@RequestParam(value = "date", required = false, defaultValue = "") String date,
			@RequestParam(value = "slot", required = false, defaultValue = "") String slot,
			@RequestParam(value = "personaldetails", required = false, defaultValue = "") String personaldetails,
			@RequestParam("file") MultipartFile[] files) {
		book.setTestname(testname);
		book.setLabname(labname);
		book.setDate(date);
		StringBuilder fileNames = new StringBuilder();
		for (MultipartFile file : files) {
			Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
			fileNames.append(file.getOriginalFilename() + " ");
			try {
				Files.write(fileNameAndPath, file.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		String path = fileNames.toString();
		book.setPath(path);
		bookService.save(book);
		return "welcome";

	}

	@GetMapping("/BookingList")
	public String viewBooking(Model model) {
		model.addAttribute("bookinglist", bookService.findAll());
		return "BookingList";
	}

	@RequestMapping("{bookings}/status")
	public String checkStatus(Model model, @RequestParam(name = "status") String status, @PathVariable Long bookings) {
		bookService.updateStatus(status, bookings);
		model.addAttribute("bookinglist", bookService.findAll());
		return "BookingList";
	}

	@GetMapping("/Mybooking")
	public String checkBooing(Model model, @RequestParam(name = "username") String username) {
		List<Booking> book = new ArrayList<Booking>();
		book = bookService.searchBookingByUsername(username);
		model.addAttribute("bookinglist", book);
		return "MyBookings";
	}
}
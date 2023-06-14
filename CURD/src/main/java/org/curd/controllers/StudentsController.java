package org.curd.controllers;

import java.util.List;

import org.curd.payloads.ApiResponse;
import org.curd.payloads.StudentsDto;
import org.curd.services.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Students")
public class StudentsController {
	@Autowired
	private StudentsService studentsService;
	
	@PostMapping("/")
	public ResponseEntity<StudentsDto> createStudents( @RequestBody StudentsDto studentsDto){
		StudentsDto createStudentsDto=this.studentsService.createStudents(studentsDto);
		return new ResponseEntity<StudentsDto>(createStudentsDto, HttpStatus.CREATED);
	}
	
	//PUT-update Recruiter
	@PutMapping("/{StudentsId}")
	public ResponseEntity<StudentsDto> updateStudents( @RequestBody StudentsDto studentsDto,@PathVariable Integer StudentsId){
		
		StudentsDto updateStudents=this.studentsService.updateStudents(studentsDto, StudentsId);
		return new ResponseEntity<StudentsDto>(updateStudents, HttpStatus.OK);
		
	}
	
	//DELETE -delete Recruiter
	@DeleteMapping("/{StudentsId}")
	public ResponseEntity<ApiResponse> deleteStudents(@PathVariable("StudentsId")Integer StudentsId){
		
		this.studentsService.deleteStudents(StudentsId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Job Seeker are deleted successfully",true),HttpStatus.OK);
		
	}
	
	//GET -Recruiter get
	
	@GetMapping("/{StudentsId}")
	public ResponseEntity<StudentsDto> getSingleStudents(@PathVariable Integer StudentsId){
		
		return ResponseEntity.ok(this.studentsService.getStudents(StudentsId));
		
	}
	
	
	@GetMapping("/")
	public ResponseEntity<List<StudentsDto>> getStudents(){
		
		return ResponseEntity.ok(this.studentsService.getStudents());
		
	}

}

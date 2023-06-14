package org.curd.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.curd.entities.Students;
import org.curd.exception.ResourceNotFoundException;
import org.curd.payloads.StudentsDto;
import org.curd.repositories.StudentsRepo;
import org.curd.services.StudentsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentsServiceImpl implements StudentsService {
	
	@Autowired
	private StudentsRepo studentsRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public StudentsDto createStudents(StudentsDto studentsDto) {
		Students students=this.modelMapper.map(studentsDto, Students.class);
		Students addedstudent=this.studentsRepo.save(students);
		return this.modelMapper.map(addedstudent, StudentsDto.class);
	}

	@Override
	public StudentsDto updateStudents(StudentsDto studentsDto, Integer StudentsId) {
		Students students=this.studentsRepo.findById(StudentsId)
				.orElseThrow(()->new ResourceNotFoundException("Students","Students Id",StudentsId));
		students.setName(studentsDto.getName());
		students.setEmail(studentsDto.getEmail());
		students.setAddress(studentsDto.getAddress());
		students.setMobileno(studentsDto.getMobileno());
		students.setDateOfBirth(studentsDto.getDateOfBirth());
        Students updateStudents=this.studentsRepo.save(students);
		
		return this.modelMapper.map(updateStudents, StudentsDto.class);
		
	}

	@Override
	public void deleteStudents(Integer StudentsId) {
        Students students= this.studentsRepo.findById(StudentsId)
				 .orElseThrow(()->new ResourceNotFoundException("Students", "Students id", StudentsId));
		this.studentsRepo.delete(students);
	}

	@Override
	public StudentsDto getStudents(Integer StudentsId) {
		Students students=this.studentsRepo.findById(StudentsId)
				.orElseThrow(()-> new ResourceNotFoundException("Students", "Students Id", StudentsId));
		
		return this.modelMapper.map(students, StudentsDto.class) ;
	}

	@Override
	public List<StudentsDto> getStudents() {
		List<Students> Students=this.studentsRepo.findAll();
		List<StudentsDto> studentsDto=Students.stream().map((students)-> this.modelMapper.map(Students, StudentsDto.class)).collect(Collectors.toList());
		return studentsDto;
	}

}

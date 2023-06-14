package org.curd.services;

import java.util.List;

import org.curd.payloads.StudentsDto;






public interface StudentsService {
	

	StudentsDto createStudents(StudentsDto studentsDto);
	 
	StudentsDto updateStudents(StudentsDto studentsDto,Integer StudentsId);
	 
	 public void  deleteStudents(Integer StudentsId);
	 
	 StudentsDto getStudents(Integer StudentsId);
	 
	 List<StudentsDto> getStudents();

}

package com.bloodbank.apis.User.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserRepository,Long>{

        //Optional<User> finduserrepositoryByIdAndIsActive(Long id ,Boolean isActive);

    }


//package com.skylink.ems.holiday.repository;
//
//
//import com.skylink.ems.holiday.model.Holiday;
//import java.util.Optional;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public interface HolidayRepository extends JpaRepository<Holiday, Long> {
//
//    Optional<Holiday> findByIdAndIsActive(Long id, Boolean isActive);
//
//}

//package com.skylink.ems.department.repository;
//
//import com.skylink.ems.department.model.Department;
//import java.util.Optional;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public interface DepartmentRepository extends JpaRepository<Department, Long> {
//
//    Optional<Department> findDepartmentByIdAndIsActive(Long id, Boolean isActive);
//}
//

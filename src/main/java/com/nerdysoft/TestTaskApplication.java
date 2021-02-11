package com.nerdysoft;

import com.nerdysoft.model.Pair;
import com.nerdysoft.validation.ValidateRoom;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class TestTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestTaskApplication.class, args);
		List<Pair>validate1 = new ArrayList<>();
		List<Pair>validate2 = new ArrayList<>();
		List<Pair>invalid1 = new ArrayList<>();
		List<Pair>invalid2 = new ArrayList<>();
		List<Pair>invalid3 = new ArrayList<>();
		List<Pair>invalid4 = new ArrayList<>();
		List<Pair>invalid5 = new ArrayList<>();

		invalid1.add(new Pair(1,1));
		invalid1.add(new Pair(1,2));

		invalid2.add(new Pair(1,1));
		invalid2.add(new Pair(2,1));
		invalid2.add(new Pair(2,2));
		invalid2.add(new Pair(3,1));

		invalid3.add(new Pair(2,1));
		invalid3.add(new Pair(2,2));
		invalid3.add(new Pair(1,2));
		invalid3.add(new Pair(1,1));

		invalid4.add(new Pair(1,1));
		invalid4.add(new Pair(1,2));
		invalid4.add(new Pair(2,2));
		invalid4.add(new Pair(3,3));
		invalid4.add(new Pair(3,1));



		validate1.add(new Pair(1,1));
		validate1.add(new Pair(1,2));
		validate1.add(new Pair(2,2));
		validate1.add(new Pair(2,1));


		validate2.add(new Pair(1,1));
		validate2.add(new Pair(1,2));
		validate2.add(new Pair(0,2));
		validate2.add(new Pair(0,3));
		validate2.add(new Pair(2,3));
		validate2.add(new Pair(2,1));





		System.out.println("Error of valid 1: "+ValidateRoom.validate(validate1));
		System.out.println("Error of valid 2: "+ValidateRoom.validate(validate2));

		System.out.println("Error of invalid 1: "+ValidateRoom.validate(invalid1));
		System.out.println("Error of invalid 2: "+ValidateRoom.validate(invalid2));
		System.out.println("Error of invalid 3: "+ValidateRoom.validate(invalid3));
		System.out.println("Error of invalid 4: "+ValidateRoom.validate(invalid4));
	}

}

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
		List<Pair>pairs = new ArrayList<>();

//		pairs.add(new Pair(1,1));
//		pairs.add(new Pair(1,2));
//		pairs.add(new Pair(0,2));
//		pairs.add(new Pair(0,1));

//		pairs.add(new Pair(1,1));
//		pairs.add(new Pair(1,2));
//		pairs.add(new Pair(2,2));
//		pairs.add(new Pair(2,1));


		pairs.add(new Pair(1,1));
		pairs.add(new Pair(1,2));
		pairs.add(new Pair(0,2));
		pairs.add(new Pair(0,3));
		pairs.add(new Pair(2,3));
		pairs.add(new Pair(2,1));

//		Pair a = new Pair(0,4);
//		Pair b = new Pair(0,-4);
//		Pair c = new Pair(-3,2);
//		Pair d = new Pair(4,2);

		Pair a = new Pair(1,1);
		Pair b = new Pair(1,2);
		Pair c = new Pair(1,2);
		Pair d = new Pair(3,2);





		System.out.println(ValidateRoom.validate(pairs));

	}

}

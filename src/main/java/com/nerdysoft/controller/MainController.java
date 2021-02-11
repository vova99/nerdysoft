package com.nerdysoft.controller;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.nerdysoft.model.Pair;
import com.nerdysoft.model.Room;
import com.nerdysoft.storage.RoomStorage;
import com.nerdysoft.validation.ValidateRoom;
import jdk.nashorn.internal.ir.debug.JSONWriter;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class MainController {

    private final RoomStorage roomStorage;


    public MainController(RoomStorage roomStorage) {
        this.roomStorage = roomStorage;
    }


    @ExceptionHandler(HttpMessageNotReadableException.class)
    public final ResponseEntity<Object> handleUserHasNoAvailableHabitDictionaryException() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("error","Parse error exception!");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonObject.toString());
    }

    @GetMapping({"/","/create"})
    public String getIndex(){
        return "room";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable int id, Model model){
        model.addAttribute("room",roomStorage.getById(id));
        return "room";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable int id, Room room){
        roomStorage.update(room);
        return "redirect:/all";
    }

    @GetMapping("/delete/{id}")
    public String update(@PathVariable int id){
        roomStorage.delete(roomStorage.getById(id));
        return "redirect:/all";
    }


    @GetMapping("/all")
    public String all(Model model){
        model.addAttribute("rooms",roomStorage.all());
        return "allRooms";
    }



    @ResponseBody
    @PostMapping("/validateRoom")
    public ResponseEntity<Object> validateRoom(@RequestBody Room room) throws JSONException {
        String hasError = ValidateRoom.validate(room.getRoom());
        if (hasError.isEmpty()) {
            roomStorage.update(room);
            return new ResponseEntity<>(room, HttpStatus.OK);
        }else{
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("error",hasError);
            return new ResponseEntity<>(jsonObject.toString(), HttpStatus.BAD_REQUEST);
        }
    }
}

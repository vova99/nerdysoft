package com.nerdysoft.validation;

import com.nerdysoft.model.Pair;

import java.awt.geom.Line2D;
import java.util.List;

public class ValidateRoom {

    public static boolean isClockwise(List<Pair> pairs){
        int sum = 0;
        Pair first,second;
        for (int i=1;i<pairs.size();i++){
            first = pairs.get(i-1);
            second = pairs.get(i);
            sum += (second.getX()-first.getX())*(second.getY()+first.getY());
        }
       return sum > 0;
    }

    public static boolean isDiagonal(Pair a, Pair b){
        return a.getX()!=b.getX() && a.getY()!=b.getY();
    }


    public static boolean isIntersection(Pair a, Pair b, Pair c, Pair d){
        Line2D line1 = new Line2D.Float(a.getX(),a.getY(),b.getX(),b.getY());
        Line2D line2 = new Line2D.Float(c.getX(),c.getY(),d.getX(),d.getY());
        return line2.intersectsLine(line1);
    }

    public static boolean isFiniteArea(List<Pair> pairs){
        Pair pair1,pair2,pair3;
        pair1 = pairs.get(0);
        pair2 = pairs.get(pairs.size()-1);
        pair3 = pairs.get(pairs.size()-2);
        return (pair1.getX() == pair2.getX() && pair2.getY() == pair3.getY())
                || (pair1.getY() == pair2.getY() && pair2.getX() == pair3.getX());
    }

    public static String validate(List<Pair> pairs){
        if(pairs.size()>=4) {
            if(!isFiniteArea(pairs)){
                return "Infinite area!";
            }
            if(!isClockwise(pairs)){
                return "Clockwise error!";
            }
            for (int i = 1; i < pairs.size(); i++) {
                int k=0;
                for(int j=i+1;j<pairs.size();j++){
                    k++;
                    if(k==pairs.size()-2) break;
                    if(isIntersection(pairs.get(i-1),pairs.get(i),pairs.get(j%pairs.size()),pairs.get((j+1)%pairs.size()))){
                        System.out.println(pairs.get(i-1));
                        System.out.println(pairs.get(i));
                        System.out.println(pairs.get(j%pairs.size()));
                        System.out.println(pairs.get((j+1)%pairs.size()));
                        System.out.println();
                        return "Lines intersects!";
                    }
                }
                if(isDiagonal(pairs.get(i-1),pairs.get(i))){
                    return "Diagonal error!";
                }
            }
            if(isDiagonal(pairs.get(0),pairs.get(pairs.size()-1))){
                return "Diagonal error!";
            }
            return "";
        }
        else {
            return "Size smaller than 4 points";
        }
    }
}

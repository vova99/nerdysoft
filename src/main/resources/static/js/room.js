document.addEventListener("DOMContentLoaded", function(event) {
    draw();
});

function add() {
    var x = document.getElementById("x").value;
    var y = document.getElementById("y").value;

    if(x =="" || y==""){
        alert("Enter numbers")
    }else {
        var table = document.getElementById("mainTable");

        var row = table.insertRow(-1);

        var cell1 = row.insertCell(0);
        var cell2 = row.insertCell(1);
        var cell3 = row.insertCell(2);
        cell1.innerHTML = x;
        cell2.innerHTML = y;
        cell3.innerHTML = "<button type=\"button\" onclick=\"drop(this)\">Delete</button>";
        document.getElementById("x").value="";
        document.getElementById("y").value="";
    }
}

function drop(obj){
    var tr = obj.closest("tr");
    tr.remove();
}

function sendRequest() {
    var id = document.getElementById("idOfRoom").value;
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.status == 200) {
            location.replace("/all");
        }else if(this.readyState==4){
            alert(this.responseText);
        }
    };

    xhttp.open("POST", "/validateRoom", true);
    xhttp.setRequestHeader("Content-type", "application/json");
    xhttp.send("{\"id\":"+id+", \"room\":"+JSON.stringify(getArrayOfPointClass())+" }");
}

function getArrayOfPoint() {
    var array = [];
    var table = document.getElementById("mainTable");
    for (var i = 1; i<table.rows.length; i++) {
        var row = table.rows.item(i);
        array.push([row.cells.item(0).innerHTML, row.cells.item(1).innerHTML]);
    }
    return array;
}

class Point{
    constructor(x,y) {
        this.x = x;
        this.y = y;
    }
}

function getArrayOfPointClass() {
    var array = getArrayOfPoint();
    var newArray = [];
    console.log(array);
    for (let i = 0; i<array.length; i++) {
        newArray.push(new Point(array[i][0],array[i][1]));
    }
    console.log(newArray);
    return newArray;
}

function draw() {
    var c = document.getElementById("myCanvas");
    var ctx = c.getContext("2d");
    var arrayOfPoint = getArrayOfPoint();
    if(arrayOfPoint.length>=4){
        ctx.moveTo(arrayOfPoint[0][0], arrayOfPoint[0][1]);
        for(var i=1;i<arrayOfPoint.length;i++){
            ctx.lineTo(arrayOfPoint[i][0], arrayOfPoint[i][1]);
        }
        ctx.lineTo(arrayOfPoint[0][0], arrayOfPoint[0][1]);
        ctx.stroke();
    }
}
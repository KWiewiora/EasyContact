<?php
    require "conn.php";
    $user_email = $_POST["user_name"];
    $user_pass = $_POST["user_pass"];
    $mysql_qry = "SELECT * FROM uzytkownicy WHERE uzytkownicy.email = '$user_email' AND  uzytkownicy.haslo = '$user_pass';";
    $result = mysqli_query($conn, $mysql_qry);
    if(mysqli_num_rows($result) > 0){
        echo "logowanie udało się.";
    }
    else {
        echo "logowanie nie udało się.";
    }
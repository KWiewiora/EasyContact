<?php
    $db_name =  "baza";
    $mysql_username = "";
    $mysql_password = "";
    $server_name = "localhost";
    $conn = mysqli_connect($server_name, $mysql_username, $mysql_password, $db_name);
    if($conn){
        echo "udało się połączyć do bazy danych";
    }
    else {
        echo "ERROR: nie udało się połączyć z bazą";
    }
?>
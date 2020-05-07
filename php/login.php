<?php
    require "conn.php";
    $user_name = "";
    $user_pass = "";
    $mysql_qry = "select * from ";
    $result = mysql_query($conn, $mysql_qry);
    if(mysqli_num_rows($result) > 0){
        echo "udało się zalogować";
    }
    else{
        echo "ERROR: nie udało się zalogować";
    }
?>

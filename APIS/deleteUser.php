<?php
$serverName="localhost";
$userName="root";
$password="abd123456";
$db_name="book_viewer";
$userid=$_POST["id"];
$conn=new mysqli($serverName,$userName,$password,$db_name);//connection object
if($conn->connect_error){
     //error in connection
    //die
}else{
    //connection sucessfully
    $sqlStatement="delete from user where user_id='$userid' ";
    $result=$conn->query($sqlStatement);
    if($result===true){
        //there is data
        
            $user["userid"]=$userid;
            $user["username"]="empty";
            $user["useremail"]="empty";
            $user["userpassword"]="empty";
            $user["userphone"]="empty";
            $user["userqueryresult"]=true;
            $users[]=$user;
            echo json_encode($users);
    }else{
            $user["userid"]=0;
            $user["username"]="empty";
            $user["useremail"]="empty";
            $user["userpassword"]="empty";
            $user["userphone"]="empty";
            $user["userqueryresult"]=false;
            $users[]=$user;
        echo json_encode($users);
    }
}
$conn->close();
?>
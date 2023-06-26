<?php
$serverName="localhost";
$userName="root";
$password="abd123456";
$db_name="book_viewer";
$userid=$_POST["id"];
$email=$_POST["email"];
$user_name=$_POST["userName"];
$user_phone=$_POST["phone"];
$user_password=$_POST["userPassword"];
$conn=new mysqli($serverName,$userName,$password,$db_name);//connection object
if($conn->connect_error){
    //error in connection
    //die("connection faield");
}else{
    //connection sucessfully
          $sqlStatement="update user set user_name='$user_name',
          user_email='$email',user_password='$user_password',
          user_phone='$user_phone' where user_id=$userid";
          $result=$conn->query($sqlStatement);
          if($result===true){
            $user["userid"]=$userid;
            $user["username"]=$user_name;
            $user["useremail"]=$email;
            $user["userpassword"]=$user_password;
            $user["userphone"]=$user_phone;
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
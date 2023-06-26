<?php
//connection parameters
$serverName="localhost";
$userName="root";
$password="abd123456";
$db_name="book_viewer";
$email=$_POST["email"];
$user_name=$_POST["userName"];
$user_phone=$_POST["phone"];
$user_password=$_POST["userPassword"];
$emailfound=false;
$phonefound=false;
$conn=new mysqli($serverName,$userName,$password,$db_name);//connection object
if($conn->connect_error){
    //error in connection
    //die("connection faield");
}else{
     //connection sucessfully
      $sql_check_ifUserPhoneExist="select * from user where user_phone='$user_phone'";
      $ckeckResult_phone=$conn->query($sql_check_ifUserPhoneExist);
      if($ckeckResult_phone->num_rows>0){
          $phonefound=true;
      }
    $sql_check_ifUserEmailExist="select * from user where user_email='$email'";
      $ckeckResult_email=$conn->query($sql_check_ifUserEmailExist);
      if($ckeckResult_email->num_rows>0){
          $emailfound=true;
      }
      if($emailfound===false && $phonefound===false){
          //not exist
          $sqlStatement="insert into user(user_name,user_email,user_password,user_phone)
          values('$user_name','$email','$user_password','$user_phone')";
          $result=$conn->query($sqlStatement);
          if($result===true){
        
        
            $user["userid"]=-1;
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
    }else{
          //user exist
            $user["userid"]=-2;
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
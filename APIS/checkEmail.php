<?php
$serverName="localhost";
$userName="root";
$password="abd123456";
$db_name="book_viewer";
$email=$_POST["email"];
$conn=new mysqli($serverName,$userName,$password,$db_name);//connection object
if($conn->connect_error){
     //error in connection
    //die
}else{
    //connection sucessfully
    $sqlStatement="select * from user where user_email ='$email' ";
    $result=$conn->query($sqlStatement);
    if($result->num_rows>0){
        //there is data
        while($row=$result->fetch_assoc()){
            $user["userid"]=$row["user_id"];
            $user["username"]=$row["user_name"];
            $user["useremail"]=$row["user_email"];
            $user["userpassword"]=$row["user_password"];
            $user["userphone"]=$row["user_phone"];
            $user["userqueryresult"]=true;
            $users[]=$user;
        }
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
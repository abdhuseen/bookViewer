<?php
$serverName="localhost";
$userName="root";
$password="abd123456";
$db_name="book_viewer";
$userid=$_POST["userid"];
$bookid=$_POST["bookid"];
$conn=new mysqli($serverName,$userName,$password,$db_name);//connection object
if($conn->connect_error){
    die("error in connection");
}else{
    $sql="delete from  user_book where user_id_foerign=$userid and book_id_foerign=$bookid";
    $result=$conn->query($sql);
    if($result===true){
        $fav["useridfoerign"]=$userid;
        $fav["bookidfoerign"]=$bookid;
        $fav["isfav"]=true;
        $fav["user_book_query_result"]=true;
        $favs[]=$fav;
        echo json_encode($favs);
    }else{
        $fav["useridfoerign"]=0;
        $fav["bookidfoerign"]=0;
        $fav["isfav"]=true;
        $fav["user_book_query_result"]=false;
        $favs[]=$fav;
        echo json_encode($favs);
    }
}
$conn->close();
?>
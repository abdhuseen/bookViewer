<?php
$serverName="localhost";
$userName="root";
$password="abd123456";
$db_name="book_viewer";
$userid=$_POST["userid"];
$conn=new mysqli($serverName,$userName,$password,$db_name);//connection object
if($conn->connect_error){
    //die("error in connection");
}else{
    $sql="select book_id,book_name,book_author,book_year,book_image_link,book_description,book_type,book_url
     FROM book,user_book  WHERE book_id=book_id_foerign and user_id_foerign=$userid ";
    $result=$conn->query($sql);
    if($result->num_rows>0){
        while($row=$result->fetch_assoc()){
            $books["bookid"]=$row["book_id"];
            $books["bookname"]=$row["book_name"];
            $books["bookauthor"]=$row["book_author"];
            $books["bookyear"]=$row["book_year"];
            $books["bookimagelink"]=$row["book_image_link"];
            $books["bookdescription"]=$row["book_description"];
            $books["booktype"]=$row["book_type"];
            $books["bookurl"]=$row["book_url"];
            $books["bookqueryresult"]=true;
            $allbooks[]=$books;
        }
        echo json_encode($allbooks);
    }
    else{
            $books["bookid"]=0;
            $books["bookname"]="empty";
            $books["bookauthor"]="empty";
            $books["bookyear"]="empty";
            $books["bookimagelink"]="empty";
            $books["bookdescription"]="empty";
            $books["booktype"]="empty";
            $books["bookurl"]="empty";
            $books["bookqueryresult"]=false;
            $allbooks[]=$books; 
            echo json_encode($allbooks);
    }
    
}
$conn->close();
?>

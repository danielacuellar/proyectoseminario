<?php
include 'conexion.php';
  $IdLeccion=$_GET['IdLeccion'];



$sql =("SELECT COUNT(R.Completado) FROM resultados AS R LEFT JOIN
		
	   

 WHERE usuario='$IdLeccion'");


$datos = Array();
$resul = mysqli_query($conexion,$sql);
while($row = mysqli_fetch_object($resul)){
	$datos[] = $row;
}
echo json_encode($datos);
mysqli_close($conexion);

?>
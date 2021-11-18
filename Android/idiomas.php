<?php
include 'conexion.php';


$sql = "SELECT id,Nombre FROM idiomas";
$datos = Array();
$resul = mysqli_query($conexion,$sql);
while($row = mysqli_fetch_object($resul)){
	$datos[] = $row;
}
echo json_encode($datos);
mysqli_close($conexion);
?>
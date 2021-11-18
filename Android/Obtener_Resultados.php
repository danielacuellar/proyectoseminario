<?php
include 'conexion.php';
  $IdLeccion=$_GET['IdLeccion'];
 // $IdUsuario=$_GET['IdUsuario'];



$sql =("SELECT COUNT(R.Completado) AS Cont FROM resultados AS R LEFT JOIN
		Ejercicio AS E On R.IdEjercicio = E.IdEjercicio
		WHERE E.IdLeccion='$IdLeccion'");
		
		//Validar por Usuario


$datos = Array();
$resul = mysqli_query($conexion,$sql);
while($row = mysqli_fetch_object($resul)){
	$datos[] = $row;
}
echo json_encode($datos);
mysqli_close($conexion);

?>
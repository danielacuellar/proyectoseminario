<?php
include 'conexion.php';

//$id = $_GET["IdNivel"]; 
//$idUsuario = $_GET["IdUsuario"]; 

$id = 1; 

	$sql ="SELECT L.IdLeccion, L.NombreLeccion,
	(( CASE WHEN COUNT(R.Completado) = 0 THEN 0 ELSE (COUNT(R.Completado)) END)) AS Contador, L.Imagen 
	FROM lecciones AS L LEFT JOIN
	ejercicio AS E On L.IdLeccion = E.IdLeccion LEFT JOIN 
	resultados AS R On E.IdEjercicio = R.IdEjercicio
	WHERE L.IdNivel=$id";	
			
	//Validar por Usuario		
		
$datos = Array();
$resul = mysqli_query($conexion,$sql);
while($row = mysqli_fetch_object($resul)){
	$datos[] = $row;
}
echo json_encode($datos);
mysqli_close($conexion);
?>


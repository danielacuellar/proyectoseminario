<?php
include 'conexion.php';

    $IdEjercicio = $_POST["IdEjercicio"];
	$IdUsuario = $_POST["IdUsuario"];
	$Completado = 1;
    
	
	
	
	
	$consulta = "INSERT INTO resultados (IdEjercicio,IdUsuario,Completado) VALUES('$IdEjercicio','$IdUsuario','$Completado');";
	$result= mysqli_query($conexion,$consulta) or die (mysqli_error());
// if (mysqli_num_rows($result) == 1) {
	// echo "1";
// }else{
	// echo "0";
// }

mysqli_close($conexion);
?>
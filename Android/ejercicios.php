<?php
include 'conexion.php';

$id = $_GET["id"]; 

//$id = 2; 

//random ejercicios por leccion
//random de imagenes diferentes a la respuesta

	$sql ="SELECT IdEjercicio FROM ejercicio WHERE IdLeccion=$id";
	$datos = Array();
	
	$resul = mysqli_query($conexion,$sql);
	//$respuesta = mysqli_fetch_array($resul,MYSQLI_NUM);
	while($row = mysqli_fetch_row($resul)){
		$datos[] = $row;
	}
	
	$random_ideje=array_rand($datos,1);
	$ideje= $datos[$random_ideje];
	
	
	//print_r($ideje[0]);
	//mysqli_close($conexion);
	
	
	
	// $db_connection =  mysqli_connect('localhost', 'root', '', 'Idiomas');


	$sql = "SELECT URL FROM ejercicio WHERE IdEjercicio =$ideje[0]" ;
	$result = mysqli_query($conexion,$sql);
	//ya tengo el path de la foto en path[0]
	$path = mysqli_fetch_row($result);
	//$scanned_directory empieza desde 2 el array
	$scanned_directory = array_diff(scandir($path[0]), array('..', '.'));
	//print_r($path[0]);
	

	$sql = "SELECT Respuesta FROM ejercicio WHERE IdEjercicio =$ideje[0]" ;
	$result = mysqli_query($conexion,$sql);
	$respuesta = mysqli_fetch_row($result);
	

	

	//$array_without_duplicate tiene el array de los nombre de las imagenes sin el nombre de la imagen de la respuesta correcta para evitar ducplicados. 
	$array_without_duplicate = array_diff($scanned_directory, array("$respuesta[0].png"));
	
	$sql = "SELECT Pregunta FROM ejercicio WHERE IdEjercicio =$ideje[0]" ;
	$result = mysqli_query($conexion,$sql);
	$pregunta = mysqli_fetch_row($result);

	//formo un nuevo array con 3 entradas random
	$random_keys=array_rand($array_without_duplicate,3);
	
	
	$pathmod = substr($path[0], 15);
	$pathmod = "http://192.168.1.4$pathmod";
	$pathmod = str_replace("\\","/",$pathmod);
	//echo $pathmod;
	
	$send_array= array("IdEjercicio"=>$ideje[0],"Pregunta"=>$pregunta[0],"Respuesta" =>$respuesta[0],"Imagen1" =>"$pathmod$respuesta[0].png","Imagen2" => $pathmod.$array_without_duplicate[$random_keys[0]],"Imagen3" => $pathmod.$array_without_duplicate[$random_keys[1]],"Imagen4" => $pathmod.$array_without_duplicate[$random_keys[2]]);
	//$send_array= array("Pregunta" =>$pregunta[0]);
	$send_array_json = array($send_array);
	echo json_encode($send_array_json,JSON_UNESCAPED_UNICODE|JSON_UNESCAPED_SLASHES);
	
	
	//print_r($send_array);
	


?>
	
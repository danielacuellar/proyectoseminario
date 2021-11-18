<?php
include 'conexion.php';

//$id = $_GET["id"]; 
//$IdUsuario = $_GET["IdUsuario"]; 

$id = 1; 

$IdUsuario = 4;

// $sql = "SELECT N.IdNivel, N.NombreNivel, L.NombreLeccion, 
		// (SUM( CASE WHEN (R.Completado) = 0 THEN 0 ELSE (SUM(R.Completado)/10)* 100 END)/5)*100 AS Porcentaje 
		// FROM niveles AS N LEFT JOIN lecciones AS L On N.idNivel = L.idNivel LEFT JOIN 
		// ejercicio AS E On L.IdLeccion = E.IdLeccion LEFT JOIN 
		// resultados AS R On E.IdEjercicio = R.IdEjercicio 
		// GROUP BY N.IdNivel, N.NombreNivel, L.NombreLeccion";
		
	//Tomar en cuenta el orden para desplegarlo
	
	//por niveles, por idioma
	
	
	// $sql1 = "SELECT COUNT(*) FROM lecciones WHERE IdNivel = $IdNivel";
	// $result1 = mysqli_query($db_connection,$sql1);
	// $totalLecciones = mysqli_fetch_row($result1);
	
	
	
	$sql = "SELECT COUNT(*) FROM lecciones AS L LEFT JOIN
	niveles AS N ON N.idNivel = L.IdNivel LEFT JOIN
	idiomas AS I ON I.id = N.IdIdioma
	WHERE I.id = $id";
	$result = mysqli_query($conexion,$sql);
	$totalLecciones = mysqli_fetch_row($result);
	//echo $totalLecciones[0];
	
	
	$sql1 = "SELECT COUNT(*) FROM ejercicio AS E LEFT JOIN
	lecciones AS L ON L.IdLeccion = E.IdLeccion LEFT JOIN
	niveles AS N ON N.idNivel = L.IdNivel LEFT JOIN
	idiomas AS I ON I.id = N.IdIdioma
	WHERE I.id = $id";
	$result1 = mysqli_query($conexion,$sql1);
	$totalEjercicios = mysqli_fetch_row($result1);
	
	
	$sql2 = "SELECT COUNT(*) FROM resultados As R LEFT JOIN
	ejercicio AS E ON E.IdEjercicio = R.IdEjercicio LEFT JOIN
	lecciones AS L ON L.IdLeccion = E.IdLeccion INNER JOIN
	niveles AS N ON N.idNivel = L.IdNivel 
	WHERE N.IdIdioma = $id AND R.IdUsuario = $IdUsuario AND R.Completado =1
	GROUP BY N.IdNivel";
	$result2 = mysqli_query($conexion,$sql2);
	$totalEjerciciosUsuario = mysqli_fetch_row($result2);
	//echo $totalEjerciciosUsuario[0];
	
		
	$sql ="SELECT N.IdNivel, N.NombreNivel,
	( CASE WHEN ($totalEjerciciosUsuario[0]) = 0 THEN 0 ELSE ((($totalEjerciciosUsuario[0]/$totalEjercicios[0])* 100 )/$totalLecciones[0])END) AS Porcentaje, N.orden 
	FROM niveles AS N LEFT JOIN 
	lecciones AS L On N.idNivel = L.idNivel LEFT JOIN 
	ejercicio AS E On L.IdLeccion = E.IdLeccion LEFT JOIN 
	resultados AS R On E.IdEjercicio = R.IdEjercicio LEFT JOIN
	usuario AS U ON R.IdUsuario = U.id
	WHERE N.IdIdioma=$id 
	GROUP BY N.IdNivel, N.NombreNivel
	ORDER BY N.Orden ASC";	
	
	//Validar por Usuario
			
		
   $datos = Array();
   $resul = mysqli_query($conexion,$sql);
   while($row = mysqli_fetch_object($resul)){
	   $datos[] = $row;
   }
   echo json_encode($datos);
   mysqli_close($conexion);
?>


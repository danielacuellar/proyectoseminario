<?php
include 'conexion.php';
  $Nombre=$_POST['nombre'];
  $Apellido=$_POST['apellido'];
  $Correo=$_POST['correo'];
  $Usuario=$_POST['usuario'];
  $Pass=$_POST['password'];


// $Nombre="HOLA12";
// $Apellido="HOLA12";
// $Correo="HOLA12";
// $Usuario="HOLA12345";
// $Pass="HOLA12";


$sql = "SELECT COUNT(Usuario) FROM usuario WHERE Usuario = '$Usuario'";
$datos = Array();

$Resultado=mysqli_query($conexion,$sql);

while($row = mysqli_fetch_row($Resultado)){
		$datos[] = $row;
	}
$Contador= $datos[0];	


if (($Contador[0]) == 0) {
	$consulta = "INSERT INTO  usuario (NombreUsuario,ApellidoUsuario,CorreoUsuario,Usuario,ContrasenaUsuario) VALUES('$Nombre', '$Apellido', '$Correo', '$Usuario', '$Pass');";
	$result = mysqli_query($conexion,$consulta);
	
	if ($result == 1) {
		echo "1";
	}else{
		echo "0";
	}
}else{
	echo "-1";
}



mysqli_close($conexion);
?>
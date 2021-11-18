<?php
include 'conexion.php';
   $usu_usuario=$_POST['usuario'];
   $usu_password=$_POST['password'];

  // $usu_usuario="Prueballave";
  // $usu_password="c893bad68927b457dbed39460e6afd62";

$sql=("SELECT * FROM usuario WHERE usuario='$usu_usuario' AND ContrasenaUsuario='$usu_password'");

$datos = Array();
$resul = mysqli_query($conexion,$sql);
while($row = mysqli_fetch_object($resul)){
	$datos[] = $row;
}

echo json_encode($datos);



mysqli_close($conexion);
?>
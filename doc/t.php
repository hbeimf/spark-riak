<?php

$dir = './error.md';

$lines = file($dir);

//print_r($lines);

$class = [];

foreach ($lines as $line) {
	if (strpos($line, "jar:")) {
		// echo $line . "\n";
		$arr = explode(':', $line);
		// print_r($arr);

		$class[trim($arr[1])][] = $arr[0];
	}
}

print_r($class);

echo count($class) . "\n";

// php ./t.php > r.md

?>
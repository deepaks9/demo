This project has two rest endpoints
1. Request format to save Shop name and lattitude/longitude details <br>
  URL - http://localhost:9000/shops/ <br>
  Method - POST <br>
  Content type - application/json <br>
  Shop data json format -All fields mandatory <br>
  { <br>
	"shopName": "Reliance mart aundh pune", <br>
	"shopAddress":<br>{ <br>
		"number":"1", <br>
		"postCode":"411007" <br>
	} <br>
} <br>

2. Request to find nearest shop basesd on customer lattitude/longitude <br>
  URL - http://localhost:9000/shops/?longitude=73.8&lattitude=18.5 <br>
  Both the parameters longitude and lattitude are mandatory <br>

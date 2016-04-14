var map = L.map('map').setView([51.505, -0.09], 3);

L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', {
    attribution: '&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'
}).addTo(map);

var xhReq = new XMLHttpRequest();
 xhReq.open("GET", "solarData/getAll", false);
 xhReq.send(null);
 var serverResponse = JSON.parse(xhReq.responseText);

var states = serverResponse.features;

L.geoJson(states, {
    style: function(feature) {
        switch (feature.properties.potential) {
            case 'Good': return {color: "#00ff00"};
            case 'Moderate':   return {color: "#ff0000"};
        }
    }
}).addTo(map);

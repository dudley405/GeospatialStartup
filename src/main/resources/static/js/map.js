var map = L.map('map').setView([41.29,-96.36], 3);

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
            case 'Excellent': return {color: "#E82C0C", fillOpacity: 0.5, stroke:false};
            case 'Good':   return {color: "#FF530D"};
        }

     stroke: false;
     opacity: 0.2;
    }
}).addTo(map);

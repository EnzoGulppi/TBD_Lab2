package com.example.resq.Functions;

import java.util.Objects;

public class Polygon {
     public String regionToPolygon(String Region){
        if (Objects.equals(Region, "Metropolitana")) {
            Region = "POLYGON((-70.896607 -32.933391,-71.709595 -33.969179,-70.720825 -33.919051,-69.808960 -34.242080,-69.781494 -33.338177,-70.896607 -32.933391))";
        }else if(Objects.equals(Region, "Arica y Parinacota")){
            Region = "POLYGON((-69.472047 -17.504372,-69.142457 -18.152809,-69.307252 -19.131327,-70.290528 -19.224717,-70.367432 -18.351047,-69.472047 -17.504372))";
        }else if(Objects.equals(Region, "Tarapacá")){
            Region = "POLYGON((-70.285035 -19.231632,-70.010377 -21.410455,-69.644166 -21.514830,-68.479616 -20.941345,-68.957521 -18.948286,-70.285035 -19.231632))";
        }else if(Objects.equals(Region, "Antofagasta")){
            Region = "POLYGON((-70.061647 -21.439006,-70.534059 -25.825850,-67.315065 -24.012596,-67.194215 -22.802767,-68.490602 -20.947330,-70.061647 -21.439006))";
        }else if(Objects.equals(Region, "Atacama")){
            Region = "POLYGON((-70.629274 -26.043209,-71.497194 -29.186934,-69.970094 -29.483837,-68.322145 -27.026099,-68.563844 -25.290644,-70.629274 -26.043209))";
        }else if(Objects.equals(Region, "Coquimbo")){
            Region = "POLYGON((-71.500856 -29.190131,-71.533815 -32.193819,-70.325319 -32.277456,-69.830934 -30.144729,-69.973757 -29.496587,-71.500856 -29.190131))";
        }else if(Objects.equals(Region, "Valparaíso")){
            Region = "POLYGON((-71.835937 -33.894357,-70.847168 -32.922249,-70.094604 -33.055867,-70.737304 -32,023213,-71.533813 -32.190722,-71.835937 -33.894357))";
        }else if(Objects.equals(Region, "O\'Higgins")){
            Region = "POLYGON((-71.832275 -33.915633,-70.931396 -34.156894,-70.426025 -33.870035,-70.371093 -35.002628,-72.062988 -34.691568,-71.832275 -33.915633))";
        }else if(Objects.equals(Region, "Maule")){
            Region = "POLYGON((-72.107010 -34.841066,-70.423355 -35.039199,-70.448074 -35.887030,-70.957178 -36.377171,-72.694778 -35.953758,-72.107010 -34.841066))";
        }else if(Objects.equals(Region, "Ñuble")){
            Region = "POLYGON((-72.764470 -36.030953,-71.105968 -36.460293,-71.174220 -37.088978,-72.334488 -36.958200,-72.863151 -36.448587,-72.764470 -36.030953))";
        }else if(Objects.equals(Region, "Biobío")){
            Region = "POLYGON((-73.522058 -38.405718,-72.552892 -37.631458,-71.065018 -38.084104,-71.208345 -37.132521,-72.921448 -36.569999,-73.522058 -38.405718))";
        }else if(Objects.equals(Region, "La Araucanía")){
            Region = "POLYGON((-73.201278 -39.367274,-71.508650 -39.583274,-73.501582 -38.491242,-72.552892 -37.658479,-71.071843 -38.110960,-73.201278 -39.367274))";
        }else if(Objects.equals(Region, "Los Ríos")){
            Region = "POLYGON((-73.699511 -40.216820,-71.897681 -40.565104,-73.208103 -39.425291,-71.727054 -39.562230,-71.706578 -40.341786,-73.699511 -40.216820))";
        }else if(Objects.equals(Region, "Los Lagos")){
            Region = "POLYGON((-73.031082 -43.727752,-71.788912 -44.067097,-74.764228 -40.279332,-71.877206 -40.596206,-71.754354 -42.046701,-73.031082 -43.727752))";
        }else if(Objects.equals(Region, "Aysén")){
            Region = "POLYGON((-73.060564 -43.723173,-71.77181 -44.05938,-73.12523 -49.15964,-75.603293 -48.511322,-75.639227 -46.719030,-73.060564 -43.723173))";
        }else if(Objects.equals(Region, "Magallanes")){
            Region = "POLYGON((-73.184613 -49.173491,-66.442327 -55.136311,-67.208925 -55.882397,-73.465429 -54.081906,-75.616093 -48.861903,-73.184613 -49.173491))";
        }
        return Region;
    }
    //Polygon a region
    public String polygonToRegion(String Polygon){
        if (Objects.equals(Polygon, "POLYGON((-70.896607 -32.933391,-71.709595 -33.969179,-70.720825 -33.919051,-69.808960 -34.242080,-69.781494 -33.338177,-70.896607 -32.933391))")) {
            Polygon = "Metropolitana";
        }else if(Objects.equals(Polygon, "POLYGON((-69.472047 -17.504372,-69.142457 -18.152809,-69.307252 -19.131327,-70.290528 -19.224717,-70.367432 -18.351047,-69.472047 -17.504372))")){
            Polygon = "Arica y Parinacota";
        }else if(Objects.equals(Polygon, "POLYGON((-70.285035 -19.231632,-70.010377 -21.410455,-69.644166 -21.514830,-68.479616 -20.941345,-68.957521 -18.948286,-70.285035 -19.231632))")){
            Polygon = "Tarapacá";
        }else if(Objects.equals(Polygon, "POLYGON((-70.061647 -21.439006,-70.534059 -25.825850,-67.315065 -24.012596,-67.194215 -22.802767,-68.490602 -20.947330,-70.061647 -21.439006))")){
            Polygon = "Antofagasta";
        }else if(Objects.equals(Polygon, "POLYGON((-70.629274 -26.043209,-71.497194 -29.186934,-69.970094 -29.483837,-68.322145 -27.026099,-68.563844 -25.290644,-70.629274 -26.043209))")){
            Polygon = "Atacama";
        }else if(Objects.equals(Polygon, "POLYGON((-71.500856 -29.190131,-71.533815 -32.193819,-70.325319 -32.277456,-69.830934 -30.144729,-69.973757 -29.496587,-71.500856 -29.190131))")){
            Polygon = "Coquimbo";
        }else if(Objects.equals(Polygon, "POLYGON((-71.835937 -33.894357,-70.847168 -32.922249,-70.094604 -33.055867,-70.737304 -32,023213,-71.533813 -32.190722,-71.835937 -33.894357))")){
            Polygon = "Valparaíso";
        }else if(Objects.equals(Polygon, "POLYGON((-71.832275 -33.915633,-70.931396 -34.156894,-70.426025 -33.870035,-70.371093 -35.002628,-72.062988 -34.691568,-71.832275 -33.915633))")){
            Polygon = "O\'Higgins";
        }else if(Objects.equals(Polygon, "POLYGON((-72.107010 -34.841066,-70.423355 -35.039199,-70.448074 -35.887030,-70.957178 -36.377171,-72.694778 -35.953758,-72.107010 -34.841066))")){
            Polygon = "Maule";
        }else if(Objects.equals(Polygon, "POLYGON((-72.764470 -36.030953,-71.105968 -36.460293,-71.174220 -37.088978,-72.334488 -36.958200,-72.863151 -36.448587,-72.764470 -36.030953))")){
            Polygon = "Ñuble";
        }else if(Objects.equals(Polygon, "POLYGON((-73.522058 -38.405718,-72.552892 -37.631458,-71.065018 -38.084104,-71.208345 -37.132521,-72.921448 -36.569999,-73.522058 -38.405718))")){
            Polygon = "Biobío";
        }else if(Objects.equals(Polygon, "POLYGON((-73.201278 -39.367274,-71.508650 -39.583274,-73.501582 -38.491242,-72.552892 -37.658479,-71.071843 -38.110960,-73.201278 -39.367274))")){
            Polygon = "La Araucanía";
        }else if(Objects.equals(Polygon, "POLYGON((-73.699511 -40.216820,-71.897681 -40.565104,-73.208103 -39.425291,-71.727054 -39.562230,-71.706578 -40.341786,-73.699511 -40.216820))")){
            Polygon = "Los Ríos";
        }else if(Objects.equals(Polygon, "POLYGON((-73.031082 -43.727752,-71.788912 -44.067097,-74.764228 -40.279332,-71.877206 -40.596206,-71.754354 -42.046701,-73.031082 -43.727752))")){
            Polygon = "Los Lagos";
        }else if(Objects.equals(Polygon, "POLYGON((-73.060564 -43.723173,-71.77181 -44.05938,-73.12523 -49.15964,-75.603293 -48.511322,-75.639227 -46.719030,-73.060564 -43.723173))")){
            Polygon = "Aysén";
        }else if(Objects.equals(Polygon, "POLYGON((-73.184613 -49.173491,-66.442327 -55.136311,-67.208925 -55.882397,-73.465429 -54.081906,-75.616093 -48.861903,-73.184613 -49.173491))")){
            Polygon = "Magallanes";
        }
        return Polygon;
    }
}

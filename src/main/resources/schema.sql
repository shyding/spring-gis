-- Enable database GIS functions

CREATE ALIAS IF NOT EXISTS H2GIS_EXTENSION FOR "org.h2gis.ext.H2GISExtension.load";
CALL H2GIS_EXTENSION();

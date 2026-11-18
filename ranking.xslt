<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <h1>Ranking de la Arena Gestral</h1>
                <table border="1">
                    <tr>
                        <th>Posición</th>
                        <th>Nombre</th>
                        <th>Puntuación</th>
                    </tr>
                    <xsl:for-each select="ranking/jugador">
                        <tr>
                            <td>
                                <xsl:value-of select="@posicion"/>
                            </td>
                            <td>
                                <xsl:value-of select="nombre"/>
                            </td>
                            <td>
                                <xsl:value-of select="puntuacion"/>
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
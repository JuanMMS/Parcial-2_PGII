package uniquindio.empresa.model;

public class AdapterLegacy implements IConsultaTecnico {

    private final TecnicoLegacyService tecnicoLegacyService;

    public AdapterLegacy(TecnicoLegacyService tecnicoLegacyService) {
        this.tecnicoLegacyService = tecnicoLegacyService;
    }

    // ==================== MÉTODOS DE LA INTERFAZ ====================

    @Override
    public String consultarCodigoTecnico(String especialidad) {
        String[] partes = obtenerPartesRespuesta(especialidad);
        if (partes == null || partes.length < 1) {
            return "SIN_TECNICO";
        }
        return partes.trim(); // Ejemplo: "TEC-105"
    }

    @Override
    public boolean consultarDisponibilidad(String especialidad) {
        String[] partes = obtenerPartesRespuesta(especialidad);
        if (partes == null || partes.length < 2) {
            return false;
        }
        return "DISPONIBLE".equalsIgnoreCase(partes.trim()); // Retorna true o false
    }

    @Override
    public double consultarValorDesplazamiento(String especialidad) {
        String[] partes = obtenerPartesRespuesta(especialidad);
        if (partes == null || partes.length < 3) {
            return 0.0;
        }
        try {
            return Double.parseDouble(partes.trim()); // Ejemplo: 30000.0
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }

    // ==================== MÉTODOS PRIVADOS AUXILIARES ====================

    /**
     * Llama al servicio legacy y descompone la cadena enviada ("TEC-105|DISPONIBLE|30000")
     */
    private String[] obtenerPartesRespuesta(String especialidad) {
        int codigoEspecialidad = mapearEspecialidadACodigo(especialidad);

        // Llamada a la plataforma legacy externa
        String respuestaRaw = tecnicoLegacyService.consultarTecnico(codigoEspecialidad);

        if (respuestaRaw == null || respuestaRaw.isBlank()) {
            return null;
        }

        return respuestaRaw.split("\\|");
    }

    /**
     * Traduce los nombres de especialidad del nuevo sistema a los códigos numéricos requeridos por LegacySupport
     */
    private int mapearEspecialidadACodigo(String especialidad) {
        if (especialidad == null) return 100;

        switch (especialidad.trim().toLowerCase()) {
            case "mantenimiento":
            case "mantenimiento preventivo":
            case "mantenimiento correctivo":
                return 101;
            case "instalacion de redes":
            case "redes":
                return 102;
            case "recuperacion de informacion":
            case "recuperacion":
                return 103;
            case "soluciones de seguridad":
            case "seguridad":
                return 104;
            default:
                return 100;
        }
    }
}


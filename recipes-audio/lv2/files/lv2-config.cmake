include(GNUInstallDirs)

# Compute prefix relative to this file
get_filename_component(_LV2_PREFIX
    "${CMAKE_CURRENT_LIST_DIR}/../../.."
    ABSOLUTE
)

add_library(lv2::lv2 INTERFACE IMPORTED)

set_target_properties(lv2::lv2 PROPERTIES
    INTERFACE_INCLUDE_DIRECTORIES
        "${_LV2_PREFIX}/${CMAKE_INSTALL_INCLUDEDIR}"
)

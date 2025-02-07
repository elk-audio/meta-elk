# meta-elk

OpenEmbedded/Yocto layer which contains all the necessary recipes and
packages which make up the core of Elk Audio OS.

The key contributions of this layer to Elk PI Audio OS image are:
- All core Elk Audio OS software such as [SUSHI](https://github.com/elk-audio/sushi), [RASPA](https://github.com/elk-audio/raspa) and [TWINE](https://github.com/elk-audio/twine).
- Example audio plugins (MDA suite) and useful libraries for audio development (e.g. LV2, CSound, Fluidsynth)
- Extra development tools and libraries.
- Creation of users.
- Important system tools.

#### About mda-vst2 plugins
In order to include the mda-vst2 plugins into the image, you need to have a copy of the
VST 2.4 SDK and define the its path in a variable `VST2SDK_PATH` in your local.conf file:
```
VST2SDK_PATH = "path/to/the/vst2sdk/in/your/build/machine"
```

Please note that in order to redistribute a binary that includes any VST 2.x plugins you need to have signed an agreement
with Steinberg before October 2018.

## Dependencies
This layer depends on the [Qt5](https://github.com/meta-qt5/meta-qt5) layer. If you are not installing Qt in the image, you can remove the dependency by adding the following line to your local.conf:

```
BBMASK += "meta-elk/recipes-qt/qt/qtbase_git.bbappend"
```

## Supported distro features
This layer handles the following distro features:
- `user-autostart-service`: it will enable the user-autostart systemd service
- `evl`: required distro feature for Xenomai 4

### User autostart service
This systemd service will look for an executable script under `/udata/autostart.sh` and execute it if it exists.
Typical usage is to use the script to setup machine specific operations and run `sushi` with a selected configuration.

This distro feature can be enabled in the `local.conf` with `DISTRO_FEATURES += "user-autostart-service"`.

---
Copyright 2017-2025 Elk Audio AB, Stockholm, Sweden.

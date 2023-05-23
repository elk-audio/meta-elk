# meta-elk

OpenEmbedded/Yocto layer which contains all the necessary recipes and
packages which make up the core of Elk Audio OS.

The key contributions of this layer to Elk PI Audio OS image are:
- All core Elk Audio OS software such as [SUSHI](https://github.com/elk-audio/sushi), [SENSEI](https://github.com/elk-audio/sensei), [RASPA](https://github.com/elk-audio/raspa) and [TWINE](https://github.com/elk-audio/twine).
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

---
Copyright 2017-2023 Elk Audio AB, Stockholm, Sweden.

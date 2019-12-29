# Meta Elk

OpenEmbedded/Yocto Project layer which contains all necessary recipes and packages which make up the core Elk Audio OS.

## Dependencies
This layer depends on the [Qt5](https://github.com/meta-qt5/meta-qt5) layer. If you are not installing Qt in the image, you can remove the dependency by adding the following line to your local.conf

```python
BBMASK += "meta-elk/recipes-qt/qt/qtbase_git.bbappend"
```

## Contents

The key contributions of this layer to Elk PI Audio OS image are:
- All core Elk Audio OS software such as [SUSHI](https://github.com/elk-audio/sushi), [SENSEI](https://github.com/elk-audio/sensei), [RASPA](https://github.com/elk-audio/raspa) and [TWINE](https://github.com/elk-audio/twine).
- Example audio plugins and various audip porgramming language support
- All development tools and libraries.
- Creation of users.
- Important system tools.

#### About mda-vst2 plugins
In order to include mda-vst2 plugins into the image, you must add the following
line to the [mda-vst2 recipe](recipes-audio/mda-vst2-plugins/mda-vst2-plugins_0.1.bb).
This specifies the path to the vst2 SDK in your build machine:
```python
EXTRA_OECMAKE += " -DVST2_SDK_PATH=path/to/the/vst2sdk/in/your/build/machine"
```

---
Copyright 2017-2019 Modern Ancient Instruments Networked AB, dba Elk, Stockholm, Sweden.
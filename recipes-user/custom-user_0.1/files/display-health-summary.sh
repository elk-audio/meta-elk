#!/bin/bash

echo ""

if [ -f /etc/elk_image_info ]; then
    source /etc/elk_image_info
    echo -e "  Build Type:    \e[40;38;5;48m$ELK_BUILD_TYPE\e[0m"
    echo -e "  Storage Type:  \e[40;38;5;48m$ELK_STORAGE_TYPE\e[0m"
    echo -e "  Image Type:    \e[40;38;5;48m$ELK_IMAGE_TYPE\e[0m"
    echo -e "  Image Name:    \e[40;38;5;48m$ELK_IMAGE_NAME\e[0m"
else
    echo -e "  \e[1;33mWARNING: /etc/elk_image_info not found\e[0m"
fi
echo ""

if [ -f /tmp/healthcheck-summary ]; then
    while IFS= read -r line; do
        if [[ "$line" == *": OK" ]]; then
            echo -e "  \e[1;32m$line\e[0m"
        elif [[ "$line" == *": FAILED" ]]; then
            echo -e "  \e[1;31m$line\e[0m"
        else
            echo "  $line"
        fi
    done < /tmp/healthcheck-summary
    echo ""
    echo -e "  \e[2mFor full logs: journalctl -u healthcheck.service\e[0m"
else
    echo -e "  \e[1;33mHealthcheck summary not found\e[0m"
    echo -e "  \e[2mRun: systemctl status healthcheck.service\e[0m"
fi

echo ""

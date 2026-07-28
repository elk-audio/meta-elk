#!/bin/bash

GREEN='\e[32m'
RED='\e[31m'
YELLOW='\e[33m'
DIM='\e[2m'
RESET='\e[0m'

echo ""

if [ -f /etc/elk_image_info ]; then
    source /etc/elk_image_info
    echo -e "  Build Type:    ${GREEN}$ELK_BUILD_TYPE${RESET}"
    echo -e "  Storage Type:  ${GREEN}$ELK_STORAGE_TYPE${RESET}"
    echo -e "  Image Type:    ${GREEN}$ELK_IMAGE_TYPE${RESET}"
    echo -e "  Image Name:    ${GREEN}$ELK_IMAGE_NAME${RESET}"
else
    echo -e "  ${YELLOW}WARNING: /etc/elk_image_info not found${RESET}"
fi
echo ""

if [ -f /tmp/healthcheck-summary ]; then
    while IFS= read -r line; do
        if [[ "$line" == *": OK" ]]; then
            echo -e "  ${GREEN}$line${RESET}"
        elif [[ "$line" == *": FAILED" ]]; then
            echo -e "  ${RED}$line${RESET}"
        else
            echo "  $line"
        fi
    done < /tmp/healthcheck-summary
    echo ""
    echo -e "  ${DIM}For full logs: journalctl -u healthcheck.service${RESET}"
else
    echo -e "  ${YELLOW}Healthcheck summary not found${RESET}"
    echo -e "  ${DIM}Run: systemctl status healthcheck.service${RESET}"
fi

echo ""

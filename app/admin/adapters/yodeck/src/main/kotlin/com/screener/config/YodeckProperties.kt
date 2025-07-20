package com.screener.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("yodeck") class YodeckProperties(val token: String, val baseUrl: String)

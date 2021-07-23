package it.unibo.chachingservice.entity.iofog;

import java.util.List;

public class NodeIoFogResponse {
	
	    private Float lastActive;
	    private Float daemonOperatingDuration;
	    private Float daemonLastStart;
	    private Float systemAvailableDisk;
	    private Float systemAvailableMemory;
	    private Float repositoryCount;
	    private Float systemTime;
	    private Float lastStatusTime;
	    private Float processedMessages;
	    private Float lastCommandTime;
	    private Float logFileCount;
	    private String uuid;
	    private String name;
	    private String location;
	    private String gpsMode;
	    private Float latitude;
	    private Float longitude;
	    private String description;
	    private String daemonStatus;
	    private Float memoryUsage;
	    private Float diskUsage;
	    private Float cpuUsage;
	    private String memoryViolation;
	    private String diskViolation;
	    private String cpuViolation;
	    private Float systemTotalCpu;
	    private String securityStatus;
	    private String securityViolationInfo;
	    private String catalogItemStatus;
	    private String repositoryStatus;
	    private String ipAddress;
	    private String ipAddressExternal;
	    private String host;
	    private Float catalogItemMessageCounts;
	    private Float messageSpeed;
	    private String networkInterface;
	    private String dockerUrl;
	    private Float diskLimit;
	    private String diskDirectory;
	    private Float memoryLimit;
	    private Float cpuLimit;
	    private Float logLimit;
	    private String logDirectory;
	    private Boolean bluetoothEnabled;
	    private Boolean abstractedHardwareEnabled;
	    private String version;
	    private Boolean isReadyToUpgrade;
	    private Boolean isReadyToRollback;
	    private Float statusFrequency;
	    private Float changeFrequency;
	    private Float deviceScanFrequency;
	    private String tunnel;
	    private Boolean watchdogEnabled;
	    private Float dockerPruningFrequency;
	    private Float availableDiskThreshold;
	    private String logLevel;
	    private Boolean isSystem;
	    private String routerId;
	    private String createdAt;
	    private String updatedAt;
	    private Float fogTypeId;
	    private Float userId;
	    private String routerMode;
	    private Float messagingPort;
	    private Float interRouterPort;
	    private Float edgeRouterPort;
	    private List<String> upstreamRouters;
		
	    public NodeIoFogResponse() {
			super();
		}

		public Float getLastActive() {
			return lastActive;
		}

		public void setLastActive(Float lastActive) {
			this.lastActive = lastActive;
		}

		public Float getDaemonOperatingDuration() {
			return daemonOperatingDuration;
		}

		public void setDaemonOperatingDuration(Float daemonOperatingDuration) {
			this.daemonOperatingDuration = daemonOperatingDuration;
		}

		public Float getDaemonLastStart() {
			return daemonLastStart;
		}

		public void setDaemonLastStart(Float daemonLastStart) {
			this.daemonLastStart = daemonLastStart;
		}

		public Float getSystemAvailableDisk() {
			return systemAvailableDisk;
		}

		public void setSystemAvailableDisk(Float systemAvailableDisk) {
			this.systemAvailableDisk = systemAvailableDisk;
		}

		public Float getSystemAvailableMemory() {
			return systemAvailableMemory;
		}

		public void setSystemAvailableMemory(Float systemAvailableMemory) {
			this.systemAvailableMemory = systemAvailableMemory;
		}

		public Float getRepositoryCount() {
			return repositoryCount;
		}

		public void setRepositoryCount(Float repositoryCount) {
			this.repositoryCount = repositoryCount;
		}

		public Float getSystemTime() {
			return systemTime;
		}

		public void setSystemTime(Float systemTime) {
			this.systemTime = systemTime;
		}

		public Float getLastStatusTime() {
			return lastStatusTime;
		}

		public void setLastStatusTime(Float lastStatusTime) {
			this.lastStatusTime = lastStatusTime;
		}

		public Float getProcessedMessages() {
			return processedMessages;
		}

		public void setProcessedMessages(Float processedMessages) {
			this.processedMessages = processedMessages;
		}

		public Float getLastCommandTime() {
			return lastCommandTime;
		}

		public void setLastCommandTime(Float lastCommandTime) {
			this.lastCommandTime = lastCommandTime;
		}

		public Float getLogFileCount() {
			return logFileCount;
		}

		public void setLogFileCount(Float logFileCount) {
			this.logFileCount = logFileCount;
		}

		public String getUuid() {
			return uuid;
		}

		public void setUuid(String uuid) {
			this.uuid = uuid;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getLocation() {
			return location;
		}

		public void setLocation(String location) {
			this.location = location;
		}

		public String getGpsMode() {
			return gpsMode;
		}

		public void setGpsMode(String gpsMode) {
			this.gpsMode = gpsMode;
		}

		public Float getLatitude() {
			return latitude;
		}

		public void setLatitude(Float latitude) {
			this.latitude = latitude;
		}

		public Float getLongitude() {
			return longitude;
		}

		public void setLongitude(Float longitude) {
			this.longitude = longitude;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getDaemonStatus() {
			return daemonStatus;
		}

		public void setDaemonStatus(String daemonStatus) {
			this.daemonStatus = daemonStatus;
		}

		public Float getMemoryUsage() {
			return memoryUsage;
		}

		public void setMemoryUsage(Float memoryUsage) {
			this.memoryUsage = memoryUsage;
		}

		public Float getDiskUsage() {
			return diskUsage;
		}

		public void setDiskUsage(Float diskUsage) {
			this.diskUsage = diskUsage;
		}

		public Float getCpuUsage() {
			return cpuUsage;
		}

		public void setCpuUsage(Float cpuUsage) {
			this.cpuUsage = cpuUsage;
		}

		public String getMemoryViolation() {
			return memoryViolation;
		}

		public void setMemoryViolation(String memoryViolation) {
			this.memoryViolation = memoryViolation;
		}

		public String getDiskViolation() {
			return diskViolation;
		}

		public void setDiskViolation(String diskViolation) {
			this.diskViolation = diskViolation;
		}

		public String getCpuViolation() {
			return cpuViolation;
		}

		public void setCpuViolation(String cpuViolation) {
			this.cpuViolation = cpuViolation;
		}

		public Float getSystemTotalCpu() {
			return systemTotalCpu;
		}

		public void setSystemTotalCpu(Float systemTotalCpu) {
			this.systemTotalCpu = systemTotalCpu;
		}

		public String getSecurityStatus() {
			return securityStatus;
		}

		public void setSecurityStatus(String securityStatus) {
			this.securityStatus = securityStatus;
		}

		public String getSecurityViolationInfo() {
			return securityViolationInfo;
		}

		public void setSecurityViolationInfo(String securityViolationInfo) {
			this.securityViolationInfo = securityViolationInfo;
		}

		public String getCatalogItemStatus() {
			return catalogItemStatus;
		}

		public void setCatalogItemStatus(String catalogItemStatus) {
			this.catalogItemStatus = catalogItemStatus;
		}

		public String getRepositoryStatus() {
			return repositoryStatus;
		}

		public void setRepositoryStatus(String repositoryStatus) {
			this.repositoryStatus = repositoryStatus;
		}

		public String getIpAddress() {
			return ipAddress;
		}

		public void setIpAddress(String ipAddress) {
			this.ipAddress = ipAddress;
		}

		public String getIpAddressExternal() {
			return ipAddressExternal;
		}

		public void setIpAddressExternal(String ipAddressExternal) {
			this.ipAddressExternal = ipAddressExternal;
		}

		public String getHost() {
			return host;
		}

		public void setHost(String host) {
			this.host = host;
		}

		public Float getCatalogItemMessageCounts() {
			return catalogItemMessageCounts;
		}

		public void setCatalogItemMessageCounts(Float catalogItemMessageCounts) {
			this.catalogItemMessageCounts = catalogItemMessageCounts;
		}

		public Float getMessageSpeed() {
			return messageSpeed;
		}

		public void setMessageSpeed(Float messageSpeed) {
			this.messageSpeed = messageSpeed;
		}

		public String getNetworkInterface() {
			return networkInterface;
		}

		public void setNetworkInterface(String networkInterface) {
			this.networkInterface = networkInterface;
		}

		public String getDockerUrl() {
			return dockerUrl;
		}

		public void setDockerUrl(String dockerUrl) {
			this.dockerUrl = dockerUrl;
		}

		public Float getDiskLimit() {
			return diskLimit;
		}

		public void setDiskLimit(Float diskLimit) {
			this.diskLimit = diskLimit;
		}

		public String getDiskDirectory() {
			return diskDirectory;
		}

		public void setDiskDirectory(String diskDirectory) {
			this.diskDirectory = diskDirectory;
		}

		public Float getMemoryLimit() {
			return memoryLimit;
		}

		public void setMemoryLimit(Float memoryLimit) {
			this.memoryLimit = memoryLimit;
		}

		public Float getCpuLimit() {
			return cpuLimit;
		}

		public void setCpuLimit(Float cpuLimit) {
			this.cpuLimit = cpuLimit;
		}

		public Float getLogLimit() {
			return logLimit;
		}

		public void setLogLimit(Float logLimit) {
			this.logLimit = logLimit;
		}

		public String getLogDirectory() {
			return logDirectory;
		}

		public void setLogDirectory(String logDirectory) {
			this.logDirectory = logDirectory;
		}

		public Boolean getBluetoothEnabled() {
			return bluetoothEnabled;
		}

		public void setBluetoothEnabled(Boolean bluetoothEnabled) {
			this.bluetoothEnabled = bluetoothEnabled;
		}

		public Boolean getAbstractedHardwareEnabled() {
			return abstractedHardwareEnabled;
		}

		public void setAbstractedHardwareEnabled(Boolean abstractedHardwareEnabled) {
			this.abstractedHardwareEnabled = abstractedHardwareEnabled;
		}

		public String getVersion() {
			return version;
		}

		public void setVersion(String version) {
			this.version = version;
		}

		public Boolean getIsReadyToUpgrade() {
			return isReadyToUpgrade;
		}

		public void setIsReadyToUpgrade(Boolean isReadyToUpgrade) {
			this.isReadyToUpgrade = isReadyToUpgrade;
		}

		public Boolean getIsReadyToRollback() {
			return isReadyToRollback;
		}

		public void setIsReadyToRollback(Boolean isReadyToRollback) {
			this.isReadyToRollback = isReadyToRollback;
		}

		public Float getStatusFrequency() {
			return statusFrequency;
		}

		public void setStatusFrequency(Float statusFrequency) {
			this.statusFrequency = statusFrequency;
		}

		public Float getChangeFrequency() {
			return changeFrequency;
		}

		public void setChangeFrequency(Float changeFrequency) {
			this.changeFrequency = changeFrequency;
		}

		public Float getDeviceScanFrequency() {
			return deviceScanFrequency;
		}

		public void setDeviceScanFrequency(Float deviceScanFrequency) {
			this.deviceScanFrequency = deviceScanFrequency;
		}

		public String getTunnel() {
			return tunnel;
		}

		public void setTunnel(String tunnel) {
			this.tunnel = tunnel;
		}

		public Boolean getWatchdogEnabled() {
			return watchdogEnabled;
		}

		public void setWatchdogEnabled(Boolean watchdogEnabled) {
			this.watchdogEnabled = watchdogEnabled;
		}

		public Float getDockerPruningFrequency() {
			return dockerPruningFrequency;
		}

		public void setDockerPruningFrequency(Float dockerPruningFrequency) {
			this.dockerPruningFrequency = dockerPruningFrequency;
		}

		public Float getAvailableDiskThreshold() {
			return availableDiskThreshold;
		}

		public void setAvailableDiskThreshold(Float availableDiskThreshold) {
			this.availableDiskThreshold = availableDiskThreshold;
		}

		public String getLogLevel() {
			return logLevel;
		}

		public void setLogLevel(String logLevel) {
			this.logLevel = logLevel;
		}

		public Boolean getIsSystem() {
			return isSystem;
		}

		public void setIsSystem(Boolean isSystem) {
			this.isSystem = isSystem;
		}

		public String getRouterId() {
			return routerId;
		}

		public void setRouterId(String routerId) {
			this.routerId = routerId;
		}

		public String getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(String createdAt) {
			this.createdAt = createdAt;
		}

		public String getUpdatedAt() {
			return updatedAt;
		}

		public void setUpdatedAt(String updatedAt) {
			this.updatedAt = updatedAt;
		}

		public Float getFogTypeId() {
			return fogTypeId;
		}

		public void setFogTypeId(Float fogTypeId) {
			this.fogTypeId = fogTypeId;
		}

		public Float getUserId() {
			return userId;
		}

		public void setUserId(Float userId) {
			this.userId = userId;
		}

		public String getRouterMode() {
			return routerMode;
		}

		public void setRouterMode(String routerMode) {
			this.routerMode = routerMode;
		}

		public Float getMessagingPort() {
			return messagingPort;
		}

		public void setMessagingPort(Float messagingPort) {
			this.messagingPort = messagingPort;
		}

		public Float getInterRouterPort() {
			return interRouterPort;
		}

		public void setInterRouterPort(Float interRouterPort) {
			this.interRouterPort = interRouterPort;
		}

		public Float getEdgeRouterPort() {
			return edgeRouterPort;
		}

		public void setEdgeRouterPort(Float edgeRouterPort) {
			this.edgeRouterPort = edgeRouterPort;
		}

		public List<String> getUpstreamRouters() {
			return upstreamRouters;
		}

		public void setUpstreamRouters(List<String> upstreamRouters) {
			this.upstreamRouters = upstreamRouters;
		}

		@Override
		public String toString() {
			return "NodeIoFogResponse [lastActive=" + lastActive + ", daemonOperatingDuration="
					+ daemonOperatingDuration + ", daemonLastStart=" + daemonLastStart + ", systemAvailableDisk="
					+ systemAvailableDisk + ", systemAvailableMemory=" + systemAvailableMemory + ", repositoryCount="
					+ repositoryCount + ", systemTime=" + systemTime + ", lastStatusTime=" + lastStatusTime
					+ ", processedMessages=" + processedMessages + ", lastCommandTime=" + lastCommandTime
					+ ", logFileCount=" + logFileCount + ", uuid=" + uuid + ", name=" + name + ", location=" + location
					+ ", gpsMode=" + gpsMode + ", latitude=" + latitude + ", longitude=" + longitude + ", description="
					+ description + ", daemonStatus=" + daemonStatus + ", memoryUsage=" + memoryUsage + ", diskUsage="
					+ diskUsage + ", cpuUsage=" + cpuUsage + ", memoryViolation=" + memoryViolation + ", diskViolation="
					+ diskViolation + ", cpuViolation=" + cpuViolation + ", systemTotalCpu=" + systemTotalCpu
					+ ", securityStatus=" + securityStatus + ", securityViolationInfo=" + securityViolationInfo
					+ ", catalogItemStatus=" + catalogItemStatus + ", repositoryStatus=" + repositoryStatus
					+ ", ipAddress=" + ipAddress + ", ipAddressExternal=" + ipAddressExternal + ", host=" + host
					+ ", catalogItemMessageCounts=" + catalogItemMessageCounts + ", messageSpeed=" + messageSpeed
					+ ", networkInterface=" + networkInterface + ", dockerUrl=" + dockerUrl + ", diskLimit=" + diskLimit
					+ ", diskDirectory=" + diskDirectory + ", memoryLimit=" + memoryLimit + ", cpuLimit=" + cpuLimit
					+ ", logLimit=" + logLimit + ", logDirectory=" + logDirectory + ", bluetoothEnabled="
					+ bluetoothEnabled + ", abstractedHardwareEnabled=" + abstractedHardwareEnabled + ", version="
					+ version + ", isReadyToUpgrade=" + isReadyToUpgrade + ", isReadyToRollback=" + isReadyToRollback
					+ ", statusFrequency=" + statusFrequency + ", changeFrequency=" + changeFrequency
					+ ", deviceScanFrequency=" + deviceScanFrequency + ", tunnel=" + tunnel + ", watchdogEnabled="
					+ watchdogEnabled + ", dockerPruningFrequency=" + dockerPruningFrequency
					+ ", availableDiskThreshold=" + availableDiskThreshold + ", logLevel=" + logLevel + ", isSystem="
					+ isSystem + ", routerId=" + routerId + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
					+ ", fogTypeId=" + fogTypeId + ", userId=" + userId + ", routerMode=" + routerMode
					+ ", messagingPort=" + messagingPort + ", interRouterPort=" + interRouterPort + ", edgeRouterPort="
					+ edgeRouterPort + ", upstreamRouters=" + upstreamRouters + "]";
		}
}

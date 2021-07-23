package it.unibo.chachingservice.entity.iofog;

import java.util.List;

public class NodeIoFogListResponse {

	private List<NodeIoFogResponse> fogs;

	public NodeIoFogListResponse() {
		super();
	}

	public List<NodeIoFogResponse> getFogs() {
		return fogs;
	}

	public void setFogs(List<NodeIoFogResponse> fogs) {
		this.fogs = fogs;
	}

	@Override
	public String toString() {
		String response = "NodeIoFogListResponse [fogs=";
		for(NodeIoFogResponse nodeIoFogResponse : this.fogs) {
			response += nodeIoFogResponse.toString();
		}
		response += "]";
		return response;
	}
	
}

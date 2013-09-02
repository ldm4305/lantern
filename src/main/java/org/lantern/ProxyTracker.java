package org.lantern;

import java.net.InetSocketAddress;
import java.net.URI;
import java.util.Collection;

/**
 * Interface for all classes that keep track of proxies.
 */
public interface ProxyTracker extends LanternService {

    void clear();

    void clearPeerProxySet();

    void addProxy(URI jid, String hostPort);

    void addProxy(URI jid, InetSocketAddress iae);

    void addJidProxy(URI jid);

    void removePeer(URI uri);

    boolean hasJidProxy(URI uri);

    boolean hasProxy();

    /**
     * Return a collection of all proxies in order of preference for using them.
     * 
     * @return
     */
    Collection<ProxyHolder> getAllProxiesInOrderOfFallbackPreference();

    /**
     * Gets the first proxy in order of fallback preference.
     * 
     * @return
     */
    ProxyHolder firstProxy();

    /**
     * Called when a connection to a proxy fails.
     * 
     * @param proxyAddress
     *            The address of the proxy.
     */
    void onCouldNotConnect(ProxyHolder proxyAddress);

    void onError(URI peerUri);

}

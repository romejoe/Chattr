package com.stantonj.chattr.channel;

import com.google.common.eventbus.Subscribe;
import com.stantonj.chattr.eventbus.EventBus;
import com.stantonj.chattr.eventbus.EventBusRegistry;
import com.stantonj.chattr.message.Message;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jstanton on 5/2/15.
 */
public class ChannelPlugin {
    private Map<String, EventBus> WatchingChannels = new HashMap<>();

    public void JoinChannel(String id) {
        if (WatchingChannels.containsKey(id))
            return;
        EventBus tmpBus = EventBusRegistry.GetOrCreateBus(id);
        tmpBus.Subscribe(this);
        WatchingChannels.put(id, tmpBus);
    }

    public void LeaveChannel(String id) {
        if (!WatchingChannels.containsKey(id))
            return;
        WatchingChannels.get(id).UnSubscribe(this);
        WatchingChannels.remove(id);
    }

    protected void PostMessage(String channelId, Message msg) {
        WatchingChannels.get(channelId).Publish(msg);
    }

    @Subscribe
    public void ReceiveMessage(Message msg) {
        //Do nothing by default
    }
}

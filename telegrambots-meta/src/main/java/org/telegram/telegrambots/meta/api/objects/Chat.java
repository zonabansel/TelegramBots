package org.telegram.telegrambots.meta.api.objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.telegram.telegrambots.meta.api.interfaces.BotApiObject;

/**
 * @author Ruben Bermudez
 * @version 1.0
 * This object represents a Telegram chat with an user or a group
 */
@SuppressWarnings("WeakerAccess")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class Chat implements BotApiObject {

    private static final String ID_FIELD = "id";
    private static final String TYPE_FIELD = "type";
    private static final String TITLE_FIELD = "title";
    private static final String USERNAME_FIELD = "username";
    private static final String FIRSTNAME_FIELD = "first_name";
    private static final String LASTNAME_FIELD = "last_name";
    private static final String ALL_MEMBERS_ARE_ADMINISTRATORS_FIELD = "all_members_are_administrators";
    private static final String PHOTO_FIELD = "photo";
    private static final String DESCRIPTION_FIELD = "description";
    private static final String INVITELINK_FIELD = "invite_link";
    private static final String PINNEDMESSAGE_FIELD = "pinned_message";
    private static final String STICKERSETNAME_FIELD = "sticker_set_name";
    private static final String CANSETSTICKERSET_FIELD = "can_set_sticker_set";
    private static final String PERMISSIONS_FIELD = "permissions";
    private static final String SLOWMODEDELAY_FIELD = "slow_mode_delay";

    private static final String USERCHATTYPE = "private";
    private static final String GROUPCHATTYPE = "group";
    private static final String CHANNELCHATTYPE = "channel";
    private static final String SUPERGROUPCHATTYPE  = "supergroup";

    /**
     * Unique identifier for this chat.
     * This number may be greater than 32 bits and some programming languages may
     * have difficulty/silent defects in interpreting it. But it smaller than 52 bits,
     * so a signed 64 bit integer or double-precision float type are safe for storing this identifier.
     */
    @JsonProperty(ID_FIELD)
    @NonNull
    private Long id; ///< Unique identifier for this chat, not exceeding 1e13 by absolute value
    @JsonProperty(TYPE_FIELD)
    @NonNull
    private String type; ///< Type of the chat, one of “private”, “group” or “channel”
    @JsonProperty(TITLE_FIELD)
    private String title; ///< Optional. Title of the chat, only for channels and group chat
    @JsonProperty(FIRSTNAME_FIELD)
    private String firstName; ///< Optional. Username of the chat, only for private chats and channels if available
    @JsonProperty(LASTNAME_FIELD)
    private String lastName; ///< Optional. Interlocutor's first name for private chats
    @JsonProperty(USERNAME_FIELD)
    private String userName; ///< Optional. Interlocutor's last name for private chats
    /**
     * Optional. True if a group has ‘All Members Are Admins’ enabled.
     */
    @JsonProperty(ALL_MEMBERS_ARE_ADMINISTRATORS_FIELD)
    private Boolean allMembersAreAdministrators;
    @JsonProperty(PHOTO_FIELD)
    private ChatPhoto photo; ///< Optional. Chat photo. Returned only in getChat.
    @JsonProperty(DESCRIPTION_FIELD)
    private String description; ///< Optional. Description, for groups, supergroups and channel chats. Returned only in getChat.
    /**
     * Optional. Chat invite link, for groups, supergroups and channel chats.
     * Each administrator in a chat generates their own invite links, so the bot must first generate the link using
     * exportChatInviteLink.
     * Each Returned only in getChat.
     */
    @JsonProperty(INVITELINK_FIELD)
    private String inviteLink;
    @JsonProperty(PINNEDMESSAGE_FIELD)
    private Message pinnedMessage; ///< Optional. Pinned message, for groups, supergroups and channels. Returned only in getChat.
    @JsonProperty(STICKERSETNAME_FIELD)
    private String stickerSetName; ///< Optional. For supergroups, name of Group sticker set. Returned only in getChat.
    @JsonProperty(CANSETSTICKERSET_FIELD)
    private Boolean canSetStickerSet; ///< Optional. True, if the bot can change group the sticker set. Returned only in getChat.
    @JsonProperty(PERMISSIONS_FIELD)
    private ChatPermissions permissions; ///< Optional. Default chat member permissions, for groups and supergroups. Returned only in getChat.
    /**
     * Optional.
     * For supergroups, the minimum allowed delay between consecutive messages sent by each unpriviledged user.
     * Returned only in getChat.
     */
    @JsonProperty(SLOWMODEDELAY_FIELD)
    private Integer slowModeDelay;

    @JsonIgnore
    public Boolean isGroupChat() {
        return GROUPCHATTYPE.equals(type);
    }

    @JsonIgnore
    public Boolean isChannelChat() {
        return CHANNELCHATTYPE.equals(type);
    }

    @JsonIgnore
    public Boolean isUserChat() {
        return USERCHATTYPE.equals(type);
    }

    @JsonIgnore
    public Boolean isSuperGroupChat() {
        return SUPERGROUPCHATTYPE.equals(type);
    }
}

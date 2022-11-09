package sk_projekat1;

import sk_projekat1.enums.TypeFilter;
import sk_projekat1.enums.TypeSort;

import java.util.Date;
import java.util.List;

public interface Storage {
    /**
     * Check if storage exists.
     *
     * @param apsolutePath  Storage absolute path
     * @return true or false
    */
    boolean setPath(String apsolutePath);

    /**
     * Creates an empty root folder called Storage.
     *
     * @param storageName                 Storage name
     * @param storageSize                 Storage size in bytes
     * @param storagePath                 Storage absolute path
     * @param storageRestrictedExtensions Storage restricted file extensions. If you have multiple extensions, split them with the ',' character
     * @param maxFilesInFolder            Max number of files in one folder
     * @return true or false
     */
    boolean createStorage(String storageName, String storagePath, int storageSize, String storageRestrictedExtensions, int maxFilesInFolder);

    /**
     * Creates an empty root folder called 'Default Storage' with default credentials.
     * Default credentials are some constants that are predetermined.
     *
     * @return true or false
     */
    boolean createDefaultStorage();

    /*---------------------------------------------------------------------------------------------------------------------*/

    /**
     * Creates an empty folder.
     *
     * @param folderName Folder name
     * @param folderPath Folder path (Relative path from storage)
     * @return true or false
     */
    boolean createFolder(String folderName, String folderPath);

    /**
     * Creates an empty file.
     *
     * @param fileName File name
     * @param filePath File path (Relative path from storage)
     * @return true or false
     */
    boolean createFile(String fileName, String filePath);

    /**
     * Moves a file to a given new folder.
     *
     * @param oldFilePath Old File path (Relative path from storage)
     * @param newFilePath New File path (Relative path from storage)
     * @return true or false
     */
    boolean moveFile(String oldFilePath, String newFilePath);

    /**
     * Renames an existing file object.
     *
     * @param foNewName Folder or File new name
     * @param foPath    Folder or File path (Relative path from storage)
     * @return true or false
     */
    boolean renameFileObject(String foNewName, String foPath);

    /**
     * Deletes an existing file object.
     *
     * @param foPath File object path (relative path from storage)
     * @return true or false
     */
    boolean deleteFileObject(String foPath);

    /**
     * Imports one, or more, file object(s) into the storage.
     *
     * @param importLocalPath   Local disk file path
     * @param importStoragePath Storage file path (Relative path from storage)
     * @return true or false
     */
    boolean importFileObject(String[] importLocalPath, String importStoragePath);

    /**
     * Exports a file object onto the local disk.
     *
     * @param exportStoragePath Storage file path (Relative path from storage)
     * @param exportLocalPath   Local disk file path
     * @return true or false
     */
    boolean exportFileObject(String exportStoragePath, String exportLocalPath);

    /*---------------------------------------------------------------------------------------------------------------------*/

    /**
     * Lists the metadata of all files in a folder.
     *
     * @param folderPath Folder path (relative path from storage)
     * @param typeSort   Sort type for the file list
     * @param typeFilter Filter type for the file list
     */
    List<String> searchFilesInFolder(String folderPath, TypeSort typeSort, TypeFilter typeFilter);

    /**
     * Lists the metadata of all files in a folder, including subfolders.
     *
     * @param folderPath Folder path (relative path from storage)
     * @param typeSort   Sort type for the file list
     * @param typeFilter Filter type for the file list
     */
    List<String> searchFilesInFolders(String folderPath, TypeSort typeSort, TypeFilter typeFilter);

    /**
     * Lists the metadata of all files with a specific extension in a folder.
     *
     * @param fileExtension File extension type
     * @param folderPath    Folder path (relative path from storage)
     * @param typeSort      Sort type for the file list
     * @param typeFilter    Filter type for the file list
     */
    List<String> searchFilesWithExtensionInFolder(String fileExtension, String folderPath, TypeSort typeSort, TypeFilter typeFilter);

    /**
     * Lists the metadata of all files with a specific substring in a folder.
     *
     * @param fileSubstring File substring
     * @param folderPath    Folder path (relative path from storage)
     * @param typeSort      Sort type for the file list
     * @param typeFilter    Filter type for the file list
     */
    List<String> searchFilesWithSubstringInFolder(String fileSubstring, String folderPath, TypeSort typeSort, TypeFilter typeFilter);

    /**
     * Checks if file(s) with the specified name(s) is(/are) in a folder.
     *
     * @param fileName   Requested name/names files
     * @param folderPath Folder path (relative path from storage)
     * @return true or false
     */
    boolean existsInFolder(String[] fileName, String folderPath);

    /**
     * Lists a folder which includes a file with the specified name.
     *
     * @param fileName File path (Relative path from storage)
     */
    String findFileFolder(String fileName);

    /**
     * Lists the metadata of all files created or modified within a specific date range in a folder.
     *
     * @param beginDate  Start date for the search
     * @param endDate    End date for the search
     * @param folderPath Folder path (relative path from storage)
     * @param typeSort   Sort type for the file list
     * @param typeFilter Filter type for the file list
     */
    List<String> searchModifiedFilesInFolder(Date beginDate, Date endDate, String folderPath, TypeSort typeSort, TypeFilter typeFilter);
}

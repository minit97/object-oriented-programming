package com.example.object_oriented.abstraction.before;

import com.example.object_oriented.abstraction.before.mock.*;
import lombok.RequiredArgsConstructor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class CloudFileManager {
    private DbFile db;

    public List<FileInfo> getFileInfos(CloudId cloudId) {
        if (cloudId == CloudId.DROPBOX) {
            DropBoxClient dc = new DropBoxClient();
            List<DbFile> dbFiles = db.getFiles();
            ArrayList<FileInfo> result = new ArrayList<>();

            for (DbFile dbFile : dbFiles) {
                FileInfo fi = new FileInfo();
                fi.setCloudId(CloudId.DROPBOX);
                fi.setFileId(dbFile.getFileId());

                result.add(fi);
            }

            return result;
        } else if (cloudId == CloudId.BOX) {
            BoxService boxSvc = new BoxService();
            // ..
        } else if (cloudId == CloudId.SCLOUD) {
            // ..
        } else if (cloudId == CloudId.NCLOUD) {
            // ..
        } else if (cloudId == CloudId.DCLOUD) {
            // ..
        }

        return null;
    }

    public void download(FileInfo file, File localTarget) throws IOException {
        if (file.getCloudId() == CloudId.DROPBOX) {
            DropBoxClient dc = new DropBoxClient();
            FileOutputStream out = new FileOutputStream(localTarget);
            dc.copy(file.getFileId(), out);
            out.close();
        } else if (file.getCloudId() == CloudId.BOX) {
            BoxService boxSvc = new BoxService();
            InputStream is = boxSvc.getInputStream(file.getFileId());
            FileOutputStream out = new FileOutputStream(localTarget);
            CopyUtils.copy(is, out);
        }
    }

    public FileInfo upload(File file, CloudId cid) {
        if (cid == CloudId.DROPBOX) {
            // ...
        } else if (cid == CloudId.BOX) {
            // ...
        }
        return null;
    }

    public void delete(String fileId, CloudId cid) {
        if (cid == CloudId.DROPBOX) {
            // ...
        } else if (cid == CloudId.BOX) {
            // ...
        }
    }

    public List<FileInfo> search(String query, CloudId cid) {
        if (cid == CloudId.DROPBOX) {
            // ...
        } else if (cid == CloudId.BOX) {
            // ...
        }
        return null;
    }

    public FileInfo copy(FileInfo fileInfo, CloudId to) throws IOException {    // 클라우드 간 복사
        CloudId from = fileInfo.getCloudId();

        if (to == CloudId.DROPBOX) {
            DropBoxClient dbClient = new DropBoxClient();
            if (from == CloudId.BOX) {
                dbClient.copyFromUrl("http://www.box.com/files/" + fileInfo.getFileId());
            } else if (from == CloudId.SCLOUD) {
                ScloudClinet sClient = new ScloudClinet();
                InputStream is = sClient.getInputStream(fileInfo.getFileId());
                dbClient.copyFromInputStream(is, fileInfo.getName());
            } else if (from == CloudId.DCLOUD) {
                dbClient.copyFromUrl("http://www.dcloud.com/getfile?fileId" + fileInfo.getFileId());
            } else if (from == CloudId.NCLOUD) {
                NCloudClient nClinet = new NCloudClient();
                File temp = File.createTempFile("", "");
                nClinet.save(fileInfo.getFileId(), temp);
                InputStream is = new FileInputStream(temp);
                dbClient.copyFromInputStream(is, fileInfo.getName());
            }
        } else if (to == CloudId.BOX) {
            // ..
        }
        // 3개 더 있어야 한다..

        return null;
    }


}
